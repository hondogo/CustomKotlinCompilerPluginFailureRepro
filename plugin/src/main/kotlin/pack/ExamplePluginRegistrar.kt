package pack

import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.declarations.IrClass
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.symbols.UnsafeDuringIrConstructionAPI
import org.jetbrains.kotlin.ir.util.fqNameWhenAvailable
import org.jetbrains.kotlin.ir.util.isSubclassOf
import org.jetbrains.kotlin.ir.visitors.IrElementTransformerVoid
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.name.FqName


@OptIn(ExperimentalCompilerApi::class, UnsafeDuringIrConstructionAPI::class)
class ExamplePluginRegistrar : CompilerPluginRegistrar() {

    override val supportsK2: Boolean
        get() = true

    override fun ExtensionStorage.registerExtensions(configuration: CompilerConfiguration) {
        IrGenerationExtension.registerExtension(
            extension = object : IrGenerationExtension {
                override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {
                    moduleFragment.transform(
                        transformer = object : IrElementTransformerVoid() {
                            override fun visitClass(declaration: IrClass): IrStatement {

                                if (declaration.fqNameWhenAvailable?.asString() == "pack.Example") {

                                    val exampleClass = pluginContext.referenceClass(ClassId.topLevel(FqName("pack.Example")))!!


                                    // This check fails when Compose plugin is applied ( Why? )
                                    check(declaration.isSubclassOf(exampleClass.owner))


                                }
                                return super.visitClass(declaration)
                            }
                        },
                        data = null
                    )
                }
            }
        )
    }
}
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

with(extensions.getByType(KotlinMultiplatformExtension::class.java)) {
    sourceSets.jvmMain {
        dependencies {
            implementation(project(":module1"))
        }
    }
}
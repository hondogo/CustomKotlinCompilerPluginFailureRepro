plugins {
    kotlin("multiplatform") version "2.2.0-Beta1"
    id("org.jetbrains.kotlin.plugin.compose") version "2.2.0-Beta1"
    id("org.jetbrains.compose") version "1.8.0-beta02"
}

kotlin {
    jvm { }
    sourceSets.jvmMain {
        dependencies {
            implementation(compose.foundation)
        }
    }
}
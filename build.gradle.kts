import org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME

plugins {
    kotlin("jvm") version "2.0.20-RC"

    id("org.jetbrains.compose") version "1.7.0-alpha02"
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.20-RC"
}

allprojects {
    group = "org.example"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        google()
    }
}

dependencies {
    testImplementation(kotlin("test"))

    add(
        PLUGIN_CLASSPATH_CONFIGURATION_NAME,
        project(":plugin")
    )

    implementation(compose.runtime)
}
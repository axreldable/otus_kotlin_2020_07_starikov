rootProject.name = "vacancies"

pluginManagement {
    val kotlinVersion: String by settings
    val openapiVersion: String by settings

    plugins {
        kotlin("multiplatform") version kotlinVersion
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion

        id("org.openapi.generator") version openapiVersion
    }

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

// Multiplatform modules
include("ok-vc-transport-mp-vacancy-mp")

// BE (JVM) modules
include("ok-vc-be-common")
include("ok-vc-be-mappers-mp")
include("ok-vc-transport-openapi-vacancy-kt")

// Apps

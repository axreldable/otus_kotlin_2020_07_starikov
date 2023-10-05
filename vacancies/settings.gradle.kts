rootProject.name = "vacancies"

pluginManagement {
    val kotlinVersion: String by settings
    val springDependencyVersion: String by settings
    val springBootVersion: String by settings
    val openapiVersion: String by settings

    plugins {
        kotlin("multiplatform") version kotlinVersion
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion

        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyVersion

        id("org.openapi.generator") version openapiVersion
    }

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

// Multiplatform modules
include("ok-vc-mp-transport-mp")

// BE (JVM) modules
include("ok-vc-be-common")
include("ok-vc-be-mappers-mp")
include("ok-vc-be-transport-openapi")

// Apps
include("ok-vc-be-app-spring")

rootProject.name = "vacancies"

pluginManagement {
    val kotlinVersion: String by settings
    val openapiVersion: String by settings

    plugins {
        kotlin("multiplatform") version kotlinVersion
        kotlin("jvm") version kotlinVersion

        id("org.openapi.generator") version openapiVersion
    }

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

include("ok-general-hw")
include("ok-marketplace-common-mp")
include("ok-vc-transport-openapi-vacancy-kt")

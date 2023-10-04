plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    val kotestVersion: String by project

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation(project(mapOf("path" to ":ok-marketplace-common-mp")))
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

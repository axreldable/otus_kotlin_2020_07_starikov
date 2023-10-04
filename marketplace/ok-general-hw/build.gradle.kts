plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.6.0")
    testImplementation(project(":ok-marketplace-common-mp"))
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

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
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

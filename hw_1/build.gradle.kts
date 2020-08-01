plugins {
    kotlin("jvm") version "1.3.72"
    application
}

group = "ru.otus.first"
version = "1.0.0"

application {
    mainClassName = "ru.otus.first.FirstMainKt"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

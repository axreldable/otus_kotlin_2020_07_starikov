plugins {
    kotlin("multiplatform") apply false
    kotlin("jvm") apply false

    id("org.openapi.generator") apply false
}

group = "ru.otus.otuskotlin.vacancies"
version = "0.0.1"

repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm")
    id("org.openapi.generator")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    val kotlinVersion: String by project
    val moshiVersion: String by project
    val kotlinTestRunnerVersion: String by project
    val okhttpVersion: String by project

    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")
    implementation("com.squareup.moshi:moshi-adapters:$moshiVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")

    testImplementation("io.kotlintest:kotlintest-runner-junit5:$kotlinTestRunnerVersion")
}

openApiGenerate {
    val basePackage = "${project.group}.transport.openapi.vacancy"
    packageName.set(basePackage)
    generatorName.set("kotlin")
    configOptions.apply {
        put("library", "jvm-okhttp4")
        put("requestDateConverter", "toString")
    }
    inputSpec.set("${rootProject.projectDir}/openapi-specs/vacancy-api.yaml")
}

sourceSets.main {
    java.srcDirs("$buildDir/generate-resources/main/src/main/kotlin")
}

tasks {
    compileKotlin.get().dependsOn(openApiGenerate)
}

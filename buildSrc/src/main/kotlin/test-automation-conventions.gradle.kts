import buildsrc.convention.Libs

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("io.qameta.allure")
    id("io.kotest")
}

repositories { mavenCentral() }

kotlin {
    jvmToolchain(17)
    compilerOptions {
        optIn.add("kotlin.time.ExperimentalTime")
        optIn.add("kotlin.uuid.ExperimentalUuidApi")
        optIn.add("io.kotest.common.ExperimentalKotest")
    }
}

dependencies {
    // Kotest framework
    implementation(Libs.Testing.kotestAssertionsCore)
    implementation(Libs.logback)
    implementation(Libs.Testing.kotestProperty)
    implementation(Libs.Testing.kotestKtor)
    implementation(Libs.Testing.kotestAssertionsJson)
    implementation(Libs.Testing.faker)
    implementation(Libs.kotlinDate)
    implementation(Libs.Testing.kotestAssertionsDate)

    // Allure integration
    testImplementation(Libs.Testing.kotestEngine)
    testImplementation(Libs.Testing.kotestExtensionsAllure)
}

tasks.test {
    workingDir = rootProject.rootDir

    systemProperties =
        System.getProperties().asIterable().associate { it.key.toString() to it.value }
    systemProperty("kotest.framework.timeout", 3600000)
    systemProperty(
        "allure.results.directory",
        layout.buildDirectory.dir("allure-results").get().asFile.path,
    )
}

// Copy global logback.xml to module resources during build
tasks.register<Copy>("copyGlobalLogback") {
    from(rootProject.file("logback.xml"))
    into(layout.buildDirectory.dir("resources/main"))
    onlyIf { !project.file("src/main/resources/logback.xml").exists() }
}

tasks.register<Copy>("copyGlobalLogbackTest") {
    from(rootProject.file("logback.xml"))
    into(layout.buildDirectory.dir("resources/test"))
    onlyIf { !project.file("src/main/resources/logback.xml").exists() }
}

tasks.named("processResources") { dependsOn("copyGlobalLogback") }

tasks.named("processTestResources") { dependsOn("copyGlobalLogbackTest") }

allure {
    adapter.autoconfigure.set(false)
    version.set("2.34.1")
}

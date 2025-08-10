plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("io.kotest:io.kotest.gradle.plugin:6.0.0.M13")
    implementation("io.qameta.allure:io.qameta.allure.gradle.plugin:2.12.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.0")
    implementation("org.jetbrains.kotlin.plugin.power-assert:org.jetbrains.kotlin.plugin.power-assert.gradle.plugin:2.2.0")
    implementation("org.jetbrains.kotlin:kotlin-serialization:2.2.0")
}
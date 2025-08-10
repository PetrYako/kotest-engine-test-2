package buildsrc.convention

object Versions {
    const val kotlin = "2.2.0"
    const val kotest = "6.0.0.M13"
    const val kotestDate = "4.2.0"
    const val logback = "1.5.18"
    const val faker = "2.0.0-rc.10"
    const val kotlinDate = "0.7.1-0.6.x-compat"
}

object Libs {
    object Testing {
        // Kotest dependencies
        const val kotestEngine = "io.kotest:kotest-framework-engine:${Versions.kotest}"
        const val kotestAssertionsCore = "io.kotest:kotest-assertions-core:${Versions.kotest}"
        const val kotestAssertionsJson = "io.kotest:kotest-assertions-json-jvm:${Versions.kotest}"
        const val kotestAssertionsDate = "io.kotest:kotest-assertions-kotlinx-time:${Versions.kotestDate}"
        const val kotestProperty = "io.kotest:kotest-property:${Versions.kotest}"
        const val kotestKtor = "io.kotest:kotest-assertions-ktor:${Versions.kotest}"
        const val kotestExtensionsAllure = "io.kotest:kotest-extensions-allure:${Versions.kotest}"
        const val faker = "io.github.serpro69:kotlin-faker:${Versions.faker}"
    }

    const val kotlinDate = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinDate}"
    const val logback = "ch.qos.logback:logback-classic:${Versions.logback}"
}

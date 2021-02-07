object Version {
//    const val arrow = "0.11.0"
    const val http4k = "4.3.0.0"
    const val jackson = "2.12.1"
    const val java = "1.8"
    const val kotest = "4.3.2"
    const val kotlin = "1.4.30"
//    const val ktor = "1.5.1"
}

object Libraries {
//    const val arrowCore = "io.arrow-kt:arrow-core:${Version.arrow}"
//    const val arrowFx = "io.arrow-kt:arrow-fx:${Version.arrow}"
//    const val arrowSyntax = "io.arrow-kt:arrow-sytax:${Version.arrow}"
    const val http4kCore = "org.http4k:http4k-core:${Version.http4k}"
    const val http4kJackson = "org.http4k:http4k-format-jackson:${Version.http4k}"
    const val jacksonCore = "com.fasterxml.jackson.core:jackson-core:${Version.jackson}"
    const val jacksonAnnotations = "com.fasterxml.jackson.core:jackson-annotations:${Version.jackson}"
    const val jacksonDataBind = "com.fasterxml.jackson.core:jackson-databind:${Version.jackson}"
    const val jacksonKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:${Version.jackson}"
    const val jacksonJsr310 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Version.jackson}"
    const val kotestRunner = "io.kotest:kotest-runner-junit5:${Version.kotest}"
//    const val kotestArrow = "io.kotest:kotest-assertions-arrow:${Version.kotest}"
    const val kotestAssertions = "io.kotest:kotest-assertions-core:${Version.kotest}"
    const val kotestProperty = "io.kotest:kotest-property:${Version.kotest}"
//    const val ktorClientCIO = "io.ktor:ktor-client-cio:${Version.ktor}"
//    const val ktorClientJackson = "io.ktor:ktor-client-jackson:${Version.ktor}"
}
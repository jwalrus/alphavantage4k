import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version Version.kotlin apply false
}

group = "com.jwalrus"
version = "0.0.1-SNAPSHOT"

configure(subprojects) {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = Version.java
            kotlinOptions {
                allWarningsAsErrors = true
            }
            freeCompilerArgs = listOf(
                "-Xjsr305=strict",
                "-Xinline-classes"
            )
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

plugins {
    `kotlin-dsl`
}

group = "org.mobilenativefoundation.store"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.dokka.gradle.plugin)
    compileOnly(libs.maven.publish.plugin)
    compileOnly(libs.atomic.fu.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("kotlinConventionPlugin") {
            id = "org.mobilenativefoundation.store.kotlin"
            implementationClass = "org.mobilenativefoundation.store.tooling.plugins.KotlinConventionPlugin"
        }
    }
}

plugins {
    id("org.mobilenativefoundation.store.kotlin")
    alias(libs.plugins.kover)
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.core)
    api(libs.kotlinx.atomic.fu)
    implementation(libs.touchlab.kermit)
    implementation(projects.multicast)
    implementation(projects.cache)
    api(projects.core)

    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}

kover {
    reports {
        total {
            xml {
                onCheck = true
                xmlFile.set(file("${layout.buildDirectory}/reports/kover/coverage.xml"))
            }
        }
    }
}

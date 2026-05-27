plugins {
    id("org.mobilenativefoundation.store.kotlin")
}

dependencies {
    api(libs.kotlinx.atomic.fu)
    implementation(libs.kotlinx.coroutines.core)

    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}

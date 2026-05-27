package org.mobilenativefoundation.store.tooling.plugins

import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KotlinConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        with(pluginManager) {
            apply("org.jetbrains.kotlin.jvm")
            apply("com.vanniktech.maven.publish")
            apply("org.jetbrains.dokka")
            apply("kotlinx-atomicfu")
        }

        extensions.configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(21))
            }
        }

        tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = "21"
            }
        }

        extensions.configure<MavenPublishBaseExtension> {
            publishToMavenCentral(automaticRelease = true)
            signAllPublications()
        }

        tasks.withType<DokkaTask>().configureEach {
            dokkaSourceSets.configureEach {
                reportUndocumented.set(false)
                skipDeprecated.set(true)
                jdkVersion.set(21)
            }
        }
    }
}

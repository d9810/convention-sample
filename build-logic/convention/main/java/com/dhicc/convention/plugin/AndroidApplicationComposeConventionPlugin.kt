package com.dhicc.convention.plugin

import com.android.build.api.dsl.ApplicationExtension
import com.dhicc.convention.configureAndroidCompose
import com.dhicc.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")
            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)
            dependencies {
                val bom = libs.findLibrary("androidx-compose-bom").get()
                val composeBundle = libs.findBundle("compose.android.bundle").get()
                val koinBundle = libs.findBundle("koin.android.bundle").get()
                val testBundle = libs.findBundle("junit.test.bundle").get()

                add("implementation", platform(bom))
                add("implementation", composeBundle)

                add("implementation", koinBundle)

                add("debugImplementation", libs.findLibrary("androidx.compose.ui.tooling").get())
                add("testImplementation", libs.findLibrary("junit").get())
                add("testImplementation", testBundle)
                add("androidTestImplementation", platform(bom))
            }
        }
    }
}
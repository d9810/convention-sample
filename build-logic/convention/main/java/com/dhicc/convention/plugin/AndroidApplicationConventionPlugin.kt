package com.dhicc.convention.plugin

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.gradle.AbstractAppExtension
import com.dhicc.convention.configureFlavors
import com.dhicc.convention.configureKotlinAndroid
import com.dhicc.convention.configurePrintApksTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.gradle.android.cache-fix")
            }
            extension.configure<ApplicationExtension> {
                defaultConfig {
                    versionCode = SdkVersionCatalog.versionCode
                    versionName = SdkVersionCatalog.versionName
                    targetSdk = SdkVersionCatalog.targetSdkVersion
                }
                configureKotlinAndroid(this)
            }

            extensions.configure<AbstractAppExtension> {
                configOutputName(this)
            }
        }
    }
}
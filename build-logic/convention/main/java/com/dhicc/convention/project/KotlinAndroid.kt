package com.dhicc.convention.project

internal fun Project.configureKotlinAndroid(
    commonExtensions : CommonExtension<*, *, *, *>
) {
    commonExtensions.apply {
        compileSdk = SdkVersionCatalog.compileSdkVersion

        kotlin {
            jvmChainTool(17)
        }
        defaultConfig {
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }
}

fun CommonExtension<*, *, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}

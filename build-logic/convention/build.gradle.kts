plugins {
    `kotlin-dsl`
}

group = "com.dhicc.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.allopen.gradlePlugin)
}

gradlePlugin {
    plugins{
        register("AndroidApplication") {
            id = "android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
    plugins{
        register("AndroidApplicationCompose") {
            id = "android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
    }
    plugins{
        register("AndroidFeatureCompose") {
            id = "android.feature.compose"
            implementationClass = "AndroidFeatureComposeConventionPlugin"
        }
    }
    plugins{
        register("AndroidLibrary") {
            id = "android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
    }
    plugins{
        register("AndroidLibraryCompose") {
            id = "android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
    plugins{
        register("AndroidLibraryCoreCompose") {
            id = "android.library.core.compose"
            implementationClass = "AndroidLibraryCoreComposeConventionPlugin"
        }
    }
    plugins{
        register("AndroidPresentation") {
            id = "android.presentation"
            implementationClass = "AndroidPresentationConventionPlugin"
        }
    }
    plugins{
        register("AndroidData") {
            id = "android.data"
            implementationClass = "AndroidDataConventionPlugin"
        }
    }
    plugins{
        register("AndroidHilt") {
            id = "android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}
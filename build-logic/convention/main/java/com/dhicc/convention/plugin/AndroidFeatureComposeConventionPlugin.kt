import com.android.build.gradle.LibraryExtension
import com.dhicc.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                     testInstrumentationRunner = "com.easy.defi.app.core.testing.EasyTestRunner"
                }
            }
            dependencies {
                add("implementation", libs.findLibrary("coil.kt").get())
                add("implementation", libs.findLibrary("coil.kt.compose").get())

                add("implementation", libs.findLibrary("androidx.compose.viewmodel").get())
                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())

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
import com.dhicc.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.gradle.android.cache-fix")
                apply("dagger.hilt.android.plugin")
            }

            dependencies {
                add("implementation", (libs.findLibrary("hilt.android").get()))
                add("android", (libs.findLibrary("hilt.compiler").get()))
                "kaptAndroidTest"(libs.findLibrary("hilt.compiler").get())
            }
        }
    }
}
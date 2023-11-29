class AndroidDataConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.gradle.android.cache-fix")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>.named("libs")
            dependencies {
                add("implementation", project(":domain"))

                add("implementation", libs.findBundle("firebase-libraries").get())
            }
        }
    }
}
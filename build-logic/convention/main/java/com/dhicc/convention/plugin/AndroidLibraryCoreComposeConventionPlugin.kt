class AndroidLibraryCoreComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }

            extentions.configure<LibraryExtension> {
                configureSdkVersionCatalog(this)
                configureComposeCommon(this)
                with(defaultConfig) {
                    versionCode = versionCodeProperty
                    versionName = versionNameProperty
                }
            }
        }
    }
}
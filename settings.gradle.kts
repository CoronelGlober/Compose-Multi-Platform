pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
rootProject.name = "DemoComposeMulti"


include(":android")
include(":desktop")
include(":common")
include(":server")
include("iOS")

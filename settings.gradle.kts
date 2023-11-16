enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "KotlinCompilerPluginDependency"
include("common")
include("plugins:plugin-gradle")
include("plugins:plugin-kotlin")
include("repro")

plugins {
    id("com.android.library")
    id("convention.library")
    id("dep.plugin") version "1.0-SNAPSHOT"
}

group = "com.plugin.dep"
version = "1.0-SNAPSHOT"

dependencies {
    commonMainApi(projects.common)
}
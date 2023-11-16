plugins {
    java
}

group = "com.plugin.dep"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}

buildscript {
    dependencies {
        classpath(libs.android.gradle)
    }
}

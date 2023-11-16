import com.android.build.gradle.internal.dsl.DefaultConfig
import com.android.build.gradle.internal.dsl.InternalCommonExtension
import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    kotlin("multiplatform")
}

val libs = the<LibrariesForLibs>()
val javaVersion = JavaVersion.toVersion(libs.versions.java.get())

kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvmToolchain(javaVersion.majorVersion.toInt())
}

android {

    namespace = "com.plugin.dep.${project.name}"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        targetSdk = 34

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
    }
}


fun android(configure: Action<InternalCommonExtension<*, *, DefaultConfig, *, *>>) =
    extensions.configure("android", configure)
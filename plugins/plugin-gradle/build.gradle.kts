plugins {
    kotlin("jvm")
    `java-gradle-plugin`
    `maven-publish`
}

group = "com.plugin.dep"
version = "1.0-SNAPSHOT"

gradlePlugin {
    plugins {
        create("dep") {
            id = "dep.plugin"
            implementationClass = "com.plugin.dep.DepGradlePlugin"
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("dep-gradle") {
            from(components["java"])

            artifactId = project.name

            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
        }
    }
}

dependencies {
    implementation(libs.kotlin.gradle.plugin.api)
}
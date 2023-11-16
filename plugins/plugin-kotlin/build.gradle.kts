plugins {
    kotlin("jvm")
    kotlin("kapt")

    `maven-publish`
}

group = "com.plugin.dep"
version = "1.0-SNAPSHOT"

publishing {
    publications {
        create<MavenPublication>("dep") {
            println("components: ${components.names.joinToString()}")
            from(components["kotlin"])

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
    compileOnly(libs.kotlin.compiler.embeddable)

    implementation(projects.common)

    implementation(libs.autoservice)
    kapt(libs.autoservice)
}
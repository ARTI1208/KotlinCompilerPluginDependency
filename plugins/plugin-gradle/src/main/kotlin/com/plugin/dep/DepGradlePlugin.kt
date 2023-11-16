package com.plugin.dep

import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilerPluginSupportPlugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption

@Suppress("unused")
class DepGradlePlugin : KotlinCompilerPluginSupportPlugin {

    override fun applyToCompilation(kotlinCompilation: KotlinCompilation<*>): Provider<List<SubpluginOption>> {
        val project = kotlinCompilation.target.project

        return project.provider {
            listOf(SubpluginOption(
                "projectDir",
                project.projectDir.path
            ))
        }
    }

    override fun getCompilerPluginId(): String {
        return "dep.plugin.compiler"
    }

    override fun getPluginArtifact(): SubpluginArtifact {
        return SubpluginArtifact("com.plugin.dep", "plugin-kotlin", "1.0-SNAPSHOT")
    }

    override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean {
        return true
    }
}
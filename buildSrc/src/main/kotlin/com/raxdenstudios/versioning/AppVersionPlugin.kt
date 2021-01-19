package com.raxdenstudios.versioning

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.register

open class AppVersionPlugin : Plugin<Project> {

  private lateinit var extension: AppVersionExtension

  override fun apply(project: Project) {
    extension = project.extensions.create("versioning")

    project.registerPrintVersionsTask()
    project.registerReleaseCandidateBranchTask()
    project.registerReleaseCandidateTagTask()

    val provider = VersionPropertiesProvider(project)
    extension.versionCode = provider.versionCode
    extension.versionName = provider.versionName

    project.afterEvaluate {
      pluginManager.withPlugin("com.android.application") { configure() }
      pluginManager.withPlugin("com.android.dynamic-feature") { configure() }
    }
  }

  private fun Project.registerReleaseCandidateTagTask() {
    tasks.register<ReleaseCandidateTagTask>("releaseCandidateTag") {
      username = extension.credentials.user
      password = extension.credentials.password
    }
  }

  private fun Project.registerReleaseCandidateBranchTask() {
    tasks.register<CreateReleaseCandidateBranchTask>("releaseCandidate") {
      username = extension.credentials.user
      password = extension.credentials.password
    }
  }

  private fun Project.registerPrintVersionsTask() {
    tasks.register("printVersions") {
      doLast {
        println("versionCode: ${extension.versionCode}")
        println("versionName: ${extension.versionName}")
      }
    }
  }

  private fun Project.configure() {
    extensions.getByType<BaseExtension>().run {
      defaultConfig.versionName = extension.versionName
      defaultConfig.versionCode = extension.versionCode
    }
  }
}

package com.raxdenstudios.versioning

import org.ajoberstar.grgit.Credentials
import org.ajoberstar.grgit.Grgit
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

open class CreateReleaseCandidateBranchTask : DefaultTask() {

  private val provider: VersionPropertiesProvider by lazy { VersionPropertiesProvider(project) }

  private val masterBranch = "master"
  private val releaseBranch by lazy { "releases/release-${provider.major}.${provider.minor}" }
  private val commitMessage by lazy { "Bump version to ${provider.versionName}" }

  @Input
  var username: String = ""

  @Input
  var password: String = ""

  @TaskAction
  fun execute() {
    Grgit.open { credentials = Credentials(username, password) }.run {
      checkoutBranch(masterBranch)
      bumpVersion()
      createReleaseCandidateBranch()
      close()
    }
  }

  private fun Grgit.createReleaseCandidateBranch() = push {
    remote = "origin"
    refsOrSpecs = listOf("HEAD:refs/heads/$releaseBranch")
  }

  private fun Grgit.bumpVersion() {
    provider.increaseMinorVersion()
    add { patterns = mutableSetOf("version.properties") }
    commit { message = commitMessage }
    push()
  }
}



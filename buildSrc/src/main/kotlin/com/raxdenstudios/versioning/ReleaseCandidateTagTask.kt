package com.raxdenstudios.versioning

import org.ajoberstar.grgit.Credentials
import org.ajoberstar.grgit.Grgit
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

open class ReleaseCandidateTagTask : DefaultTask() {

  private val provider: VersionPropertiesProvider by lazy { VersionPropertiesProvider(project) }

  private val releaseBranch by lazy { "releases/release-${provider.major}.${provider.minor}" }
  private val commitMessage by lazy { "Bump version to ${provider.versionName}" }
  private val tagName by lazy { provider.versionName }

  @Input
  var username: String = ""

  @Input
  var password: String = ""

  @TaskAction
  fun execute() {
    Grgit.open { credentials = Credentials(username, password) }.run {
      checkoutBranch(releaseBranch)
      createTagRelease()
      bumpVersion()
      close()
    }
  }

  private fun Grgit.createTagRelease() {
    tag.add { name = tagName }
    push { tags = true }
  }

  private fun Grgit.bumpVersion() {
    provider.increasePatchVersion()
    add { patterns = mutableSetOf("version.properties") }
    commit { message = commitMessage }
    push()
  }
}

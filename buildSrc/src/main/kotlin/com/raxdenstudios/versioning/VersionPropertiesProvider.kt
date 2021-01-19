package com.raxdenstudios.versioning

import org.gradle.api.Project
import java.io.File
import java.io.FileInputStream
import java.util.*

class VersionPropertiesProvider(
  private val project: Project
) {

  private val filePath by lazy { "${project.rootDir.absolutePath}/version.properties" }
  private val propertiesFile by lazy { File(filePath) }
  private val properties by lazy { Properties().apply { load(FileInputStream(propertiesFile)) } }

  val major: Int
    get() = properties.getPropertyOrDefault("MAJOR", "0").toInt()
  val minor: Int
    get() = properties.getPropertyOrDefault("MINOR", "0").toInt()
  val patch: Int
    get() = properties.getPropertyOrDefault("PATCH", "0").toInt()
  val dev: Int
    get() = properties.getPropertyOrDefault("DEV", "0").toInt()
  val versionCode: Int
    get() = major * 1000000 + minor * 10000 + patch * 100 + dev
  val versionName: String
    get() = "${major}.${minor}.${patch}"

  fun increaseMinorVersion() {
    properties.setProperty("MINOR", minor.inc().toString())
    val outputStreamWriter = propertiesFile.writer()
    properties.store(outputStreamWriter, null)
    outputStreamWriter.close()
  }

  fun increasePatchVersion() {
    properties.setProperty("PATCH", patch.inc().toString())
    val outputStreamWriter = propertiesFile.writer()
    properties.store(outputStreamWriter, null)
    outputStreamWriter.close()
  }
}

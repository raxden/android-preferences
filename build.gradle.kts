import io.gitlab.arturbosch.detekt.detekt

buildscript {
  repositories {
    google()
    jcenter()
    maven("https://plugins.gradle.org/m2/")
  }
  dependencies {
    classpath("com.raxdenstudios:android-plugins:0.20")
  }
}

plugins {
  id("io.gitlab.arturbosch.detekt").version("1.15.0")
  id("project-report")
}

subprojects {
  apply {
    plugin("io.gitlab.arturbosch.detekt")
  }
  detekt {
    // To create detekt.yml -> gradle detektGenerateConfig
    toolVersion = "1.15.0"
    config = files("${rootProject.projectDir}/config/detekt/detekt.yml")
    buildUponDefaultConfig = true

    reports {
      html {
        enabled = true
        destination = file("${rootProject.projectDir}/reports/detekt.html")
      }
    }
  }
}

allprojects {
  repositories {
    google()
    jcenter()
    maven("https://jitpack.io")
  }
}

tasks {
  val clean by registering(Delete::class) {
    delete(buildDir)
  }
}

import io.gitlab.arturbosch.detekt.detekt

buildscript {
  repositories {
    google()
    jcenter()
    maven("https://plugins.gradle.org/m2/")
  }
}

plugins {
  id("io.gitlab.arturbosch.detekt").version("1.15.0")
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
  group = "com.raxdenstudios"
  version = "0.1.0"
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

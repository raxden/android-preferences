import io.gitlab.arturbosch.detekt.detekt

buildscript {
  repositories {
    google()
    jcenter()
    maven("https://plugins.gradle.org/m2/")
  }
  dependencies {
    classpath("com.raxdenstudios:android-plugins:0.15")
  }
}

plugins {
  id("io.gitlab.arturbosch.detekt") version("1.10.0")
}

detekt {
  toolVersion = "1.10.0"
}

subprojects {
  apply {
    plugin("io.gitlab.arturbosch.detekt")
  }
  group = "com.raxdenstudios"
  version = "0.1.0"
}

allprojects {
  repositories {
    google()
    jcenter()
  }
}

tasks {
  val clean by registering(Delete::class) {
    delete(buildDir)
  }
}

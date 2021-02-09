import io.gitlab.arturbosch.detekt.detekt

buildscript {
  repositories {
    google()
    jcenter()
    maven("https://plugins.gradle.org/m2/")
  }
  dependencies {
    classpath("com.raxdenstudios:android-plugins:0.32")
  }
}

plugins {
  id("project-report")
  id("io.codearte.nexus-staging").version("0.22.0")
}

nexusStaging {
  packageGroup = "com.raxdenstudios"
  stagingProfileId = "6a4b91871b51b"
  username = "4GQ55ANT"
  password = "0I2rlYT4nM/1ZFuJO9cVo6e05RNrQhakvDFmPWJh/fJl"
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

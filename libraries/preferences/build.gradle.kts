plugins {
  id("com.raxdenstudios.android-versioning")
  id("com.raxdenstudios.android-library")
  `maven-publish`
}

group = "com.raxdenstudios"

afterEvaluate {
  publishing {
    publications {
      // Creates a Maven publication called "release".
      create<MavenPublication>("release") {
        // Applies the component for the release build variant.
        from(components["release"])

        // You can then customize attributes of the publication as shown below.
        groupId = project.group.toString()
        artifactId = project.name
        version = project.version.toString()
      }
    }
  }
}

versioning {
  versionFilePath = "./config/version.properties"
}

dependencies {
  implementation(platform(KotlinLibraries.kotlinBom))
  implementation(KotlinLibraries.kotlinStdlib)
  api(AndroidLibraries.preferences)
  api(Libraries.gson)

  testImplementation(TestLibraries.archCoreTest)
  testImplementation(TestLibraries.atslJunit)
  testImplementation(TestLibraries.atslRunner)
  testImplementation(TestLibraries.atslRules)
  testImplementation(TestLibraries.robolectric)
}

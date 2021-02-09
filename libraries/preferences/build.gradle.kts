plugins {
  id("com.raxdenstudios.version-library")
  id("com.raxdenstudios.android-library")
  id("com.raxdenstudios.publish-library")
}

versioning {
  versionFilePath = "./config/version.properties"
  group = "com.raxdenstudios"
}

publishLibrary {
  name = "AdvancedPreferences"
  description = "Improve shared preferences"
  url = "https://github.com/raxden/android-preferences"
  developerId = "raxden"
  developerName = "Ángel Gómez"
  developerEmail = "raxden.dev@gmail.com"
}

dependencies {
  implementation(KotlinLibraries.kotlinStdlib)
  implementation(KotlinLibraries.kotlinCore)
  api(KotlinLibraries.kotlinPreferences)
  api(Libraries.gson)

  testImplementation(TestLibraries.archCoreTest)
  testImplementation(TestLibraries.atslJunit)
  testImplementation(TestLibraries.atslRunner)
  testImplementation(TestLibraries.atslRules)
  testImplementation(TestLibraries.robolectric)
}

plugins {
  id("com.raxdenstudios.android-library")
  id("com.raxdenstudios.android-publish")
}

publishMavenCentral {
  pomUrl = "https://github.com/raxden/android-preferences"
  pomName = "AdvancedPreferences"
  pomDescription = "Improve shared preferences"
  pomDeveloperId = "raxden"
  pomDeveloperName = "Ángel Gómez"
  pomDeveloperEmail = "raxden.dev@gmail.com"
  pomScmConnection = "scm:git:github.com/raxden/android-preferences.git"
  pomScmDeveloperConnection = "scm:git:ssh://github.com/raxden/android-preferences.git"
  pomScmUrl = "https://github.com/raxden/android-preferences/tree/master"
}

dependencies {
  implementation(KotlinLibraries.kotlin)
  api(AndroidLibraries.preferences)
  api(Libraries.gson)

  testImplementation(TestLibraries.archCoreTest)
  testImplementation(TestLibraries.atslJunit)
  testImplementation(TestLibraries.atslRunner)
  testImplementation(TestLibraries.atslRules)
  testImplementation(TestLibraries.robolectric)
}

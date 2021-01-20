plugins {
  id("com.raxdenstudios.android-versioning")
  id("com.raxdenstudios.android-library")
  id("com.raxdenstudios.android-publishing-jcenter")
}

group = "com.raxdenstudios"

versioning {
  versionFilePath = "./config/version.properties"
}

publishJCenter {
  name = "AdvancedPreferences"
  description = "Improve shared preferences"
  username = "raxden"
  developerName = "Ángel Gómez"
  email = "raxden.dev@gmail.com"
  website = "https://github.com/raxden/android-preferences"
  bintray.apply {
    val bintrayKey: String? by project
    val bintrayRepository: String? by project
    key = bintrayKey ?: System.getenv("BINTRAY_KEY") ?: ""
    repository = bintrayRepository ?: System.getenv("BINTRAY_REPOSITORY") ?: ""
  }
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

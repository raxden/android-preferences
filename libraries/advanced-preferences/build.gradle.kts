import com.raxdenstudios.publish.model.BintrayRepository

plugins {
  id("com.raxdenstudios.version-library")
  id("com.raxdenstudios.android-library")
  id("com.raxdenstudios.publish-library")
}

versioning {
  versionFilePath = "./config/version.properties"
  group = "com.raxdenstudios"
}

val bintrayKey: String? by project
val bintrayRepository: String? by project

publishLibrary {
  name = "AdvancedPreferences"
  description = "Improve shared preferences"
  web = "https://github.com/raxden/android-preferences"
  username = "raxden"
  developerName = "Ángel Gómez"
  developerEmail = "raxden.dev@gmail.com"
  repository = BintrayRepository(
    key = bintrayKey ?: System.getenv("BINTRAY_KEY") ?: "",
    name = bintrayRepository ?: System.getenv("BINTRAY_REPOSITORY") ?: ""
  )
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

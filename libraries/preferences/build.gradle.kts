import com.raxdenstudios.versioning.Credentials

plugins {
  id("com.raxdenstudios.app-version")
  id("com.raxdenstudios.android-library")
}

versioning {
  val gitUsername: String? by project
  val gitPassword: String? by project

  credentials = Credentials(
    user = gitUsername ?: System.getenv("GIT_USER"),
    password = gitPassword ?: System.getenv("GIT_PASSWORD")
  )
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

plugins {
  id("com.raxdenstudios.android-application")
}

dependencies {
  implementation(project(Modules.libraryPreferences))

  implementation(KotlinLibraries.kotlin)
}

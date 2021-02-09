plugins {
  id("com.raxdenstudios.android-application")
}

dependencies {
  implementation(project(Modules.libraryPreferences))

  implementation(KotlinLibraries.kotlinStdlib)
  implementation(KotlinLibraries.kotlinCore)
  implementation(KotlinLibraries.kotlinPreferences)
}

object ApplicationId {
  const val id = "com.raxdenstudios.preferences"
}

object Modules {
  const val libraryPreferences = ":libraries:preferences"

  const val sample = ":sample"
}

object Versions {
  const val minSdk = 21
  const val compileSdk = 29
  const val targetSdk = 29

  const val kotlin = "1.4.21"
  const val kotlinCore = "1.3.2"
  const val kotlinPreferences = "1.1.1"

  const val gson = "2.8.6"                      // https://github.com/google/gson
  const val preferences = "1.1.1"

  const val archCoreTest = "2.0.0"
  const val atsl = "1.1.0"

  const val robolectric = "4.3.1"
}

object KotlinLibraries {
  const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
  const val kotlinCore = "androidx.core:core-ktx:${Versions.kotlinCore}"
  const val kotlinPreferences = "androidx.preference:preference-ktx:${Versions.kotlinPreferences}"
}

object Libraries {
  // Gson
  const val gson = "com.google.code.gson:gson:${Versions.gson}"
}

object TestLibraries {
  // ANDROID TEST
  const val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCoreTest}"
  const val atslJunit = "androidx.test.ext:junit:${Versions.atsl}"
  const val atslRunner = "androidx.test:runner:${Versions.atsl}"
  const val atslRules = "androidx.test:rules:${Versions.atsl}"

  // Robolectric
  const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
}

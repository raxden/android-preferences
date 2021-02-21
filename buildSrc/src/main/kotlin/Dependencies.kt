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

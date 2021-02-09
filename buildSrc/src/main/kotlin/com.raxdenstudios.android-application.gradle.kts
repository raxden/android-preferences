plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-kapt")
}

android {

  compileSdkVersion(Versions.compileSdk)

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  defaultConfig {
    applicationId = ApplicationId.id

    minSdkVersion(Versions.minSdk)
    targetSdkVersion(Versions.targetSdk)

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("debug") {
      isMinifyEnabled = false
    }
    getByName("release") {
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(
        "proguard-android-optimize.txt",
        "proguard-rules.pro"
      )
    }
  }

  buildFeatures {
    viewBinding = true
  }

  testOptions {
    unitTests.isIncludeAndroidResources = true
  }
  
  kotlinOptions {
    jvmTarget = "1.8"
  }

  packagingOptions {
    exclude("META-INF/*.kotlin_module")
  }
}

plugins {
  `kotlin-dsl`
}
// Required since Gradle 4.10+.
repositories {
  google()
  jcenter()
}

dependencies {
  implementation("com.android.tools.build:gradle:4.0.0")
  implementation(kotlin("gradle-plugin", version = "1.3.72"))
  implementation(gradleApi())
  implementation(localGroovy())
}

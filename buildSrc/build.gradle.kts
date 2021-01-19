plugins {
  `kotlin-dsl`
}
// Required since Gradle 4.10+.
repositories {
  mavenCentral()
  google()
  jcenter()
}

dependencies {
  implementation("com.android.tools.build:gradle:4.1.1")
  implementation("org.ajoberstar.grgit:grgit-gradle:4.1.0")
  implementation(kotlin("gradle-plugin", version = "1.4.10"))
  implementation(gradleApi())
  implementation(localGroovy())
}

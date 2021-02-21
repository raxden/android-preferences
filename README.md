Android Preferences
==========

Android Preferences is a component to android that allow the developers put objects in SharedPreferences using Google Json Library. Works on Android 4.1 (API level 16) and upwards.

<a href='https://github.com/raxden/android-preferences/actions?query=Continuous+Delivery'><img src='https://github.com/raxden/android-preferences/workflows/Snapshot/badge.svg'></a>
[![codecov.io](http://codecov.io/github/ReactiveX/RxJava/coverage.svg?branch=3.x)](https://codecov.io/gh/ReactiveX/RxJava/branch/3.x)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.raxdenstudios/preferences/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.raxdenstudios/preferences)

## Usage

In order to use the library, there are 3 options:

**1. Gradle dependency**

 - 	Add the following to your `build.gradle`:
 ```gradle
repositories {
	    maven { url "https://jitpack.io" }
}

dependencies {
	    compile 'com.github.raxden:AndroidPreferences:4.0.4@aar'
	    
        compile 'com.google.code.gson:gson:2.+'  //you can override Gson version if you need
}
```

**2. Maven**
- Add the following to your `pom.xml`:
 ```xml
<repository>
       	<id>jitpack.io</id>
	    <url>https://jitpack.io</url>
</repository>

<dependency>
	    <groupId>com.github.raxden</groupId>
	    <artifactId>AndroidPreferences</artifactId>
	    <version>4.0.4</version>
</dependency>
```

**3. clone whole repository**
 - Open your **commandline-input** and navigate to your desired destination folder (where you want to put the library)
 - Use the command `git clone https://github.com/raxden/AndroidPreferences.git` to download the full AndroidPreferences repository to your computer (this includes the folder of the library project as well as the example project)

### Documentation 

For a **detailed documentation**, please have a look at the [**Wiki**](https://github.com/raxden/AndroidPreferences/wiki) or the [**Javadocs**](https://jitpack.io/com/github/raxden/AndroidPreferences/4.0.4/javadoc/).

## LICENSE

    Copyright 2015 Ángel Gómez

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

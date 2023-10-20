// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependency.Core.kotlinGradlePlugin)
        classpath(Dependency.Hilt.plugin)
    }
}
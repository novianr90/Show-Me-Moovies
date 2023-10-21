import DependenciesImplementation.core
import DependenciesImplementation.coroutines
import DependenciesImplementation.hilt
import DependenciesImplementation.layout
import DependenciesImplementation.navComp

plugins {
    id(ProjectPlugin.androidApp)
    id(ProjectPlugin.kotlinAndroid)
    kotlin(ProjectPlugin.kapt)
    id(ProjectPlugin.hilt)
    id(ProjectPlugin.navComp)
}

kotlin {
    jvmToolchain(17)
}

android {
    namespace = AppConfig.nameSpace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":common:base"))
    implementation(project(":common:resources"))
    implementation(project(":common:data"))
    implementation(project(":common:domain"))

    implementation(project(":feature:home"))
    implementation(project(":feature:favorites"))
    implementation(project(":feature:details"))

    core()
    hilt()
    layout()
    coroutines()

    navComp()
}
import DependenciesImplementation.hilt
import DependenciesImplementation.room

plugins {
    id(ProjectPlugin.androidLib)
    id(ProjectPlugin.kotlinAndroid)
    kotlin(ProjectPlugin.kapt)
    id(ProjectPlugin.hilt)
}

android {
    namespace = "id.novian.common.data"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(project(":common:network"))
    implementation(project(":common:domain"))

    room()
    hilt()
}
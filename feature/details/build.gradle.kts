import DependenciesImplementation.coroutines
import DependenciesImplementation.glide
import DependenciesImplementation.hilt
import DependenciesImplementation.layout
import DependenciesImplementation.navComp
import DependenciesImplementation.viewModel

plugins {
    id(ProjectPlugin.androidLib)
    id(ProjectPlugin.kotlinAndroid)
    kotlin(ProjectPlugin.kapt)
    id(ProjectPlugin.hilt)
}

android {
    namespace = "id.novian.feature.details"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":common:base"))
    implementation(project(":common:domain"))
    implementation(project(":common:resources"))
    implementation(project(":common:data"))

    hilt()
    layout()
    viewModel()
    glide()
    coroutines()
    navComp()
}

object Dependency {

    object Core {
        const val coreKtx = "androidx.core:core-ktx:${Version.Core.ktxVersion}"

        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.Core.kotlinGradlePlugin}"
        const val gradleProject = "com.android.tools.build:gradle:${Version.Core.gradleVersion}"
        const val javaPoet = "com.squareup:javapoet:${Version.Core.javaPoetVersion}"
    }

    object Layout {
        const val appCompat = "androidx.appcompat:appcompat:${Version.Layout.appCompatVersion}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.Layout.constraintLayoutVersion}"
        const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:${Version.Layout.coordinatorLayout}"
        const val androidMaterial = "com.google.android.material:material:${Version.Layout.materialVersion}"
        const val skeletonLayout = "com.ericktijerou.koleton:koleton:${Version.Layout.skeletonLayoutVersion}"
        const val shimmer = "com.facebook.shimmer:shimmer:${Version.Layout.shimmerVersion}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Version.Hilt.version}"
        const val compiler = "com.google.dagger:hilt-android-compiler:${Version.Hilt.version}"

        const val plugin = "com.google.dagger:hilt-android-gradle-plugin:${Version.Hilt.version}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.Retrofit.version}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.Retrofit.version}"
        const val gson = "com.google.code.gson:gson:${Version.Retrofit.version}"
    }

    object OkHttp {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Version.OkHttp.version}"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Version.OkHttp.version}"
    }

    object ViewModel {
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.ViewModel.version}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.ViewModel.version}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Version.Glide.version}"
        const val compiler = "com.github.bumptech.glide:compiler:${Version.Glide.version}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Coroutines.version}"
    }

    object UnitTest {
        const val junit = "junit:junit:${Version.UnitTest.jUnitVersion}"
    }

    object AndroidTest {
        const val junit = "androidx.test.ext:junit:${Version.AndroidTest.jUnitVersion}"
        const val espresso = "androidx.test.espresso:espresso-core:${Version.AndroidTest.espressoVersion}"
    }

}
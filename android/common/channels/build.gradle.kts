@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    id("com.squareup.anvil")
}

android {
    compileSdk = 33

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    defaultConfig {
        minSdk = 33
        targetSdk = 33
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.androidx.viewmodel.compose)
    implementation(libs.androidx.fragment)

    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
    implementation(libs.coil.compose)

    implementation(project(":common:storekit"))
}

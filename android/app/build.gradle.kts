@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    kotlin("plugin.serialization")
    kotlin("android")
    id("kotlin-kapt")
    id("com.squareup.anvil")
    id("org.jetbrains.kotlin.plugin.parcelize")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.taaggg.notes.android.app"
        minSdk = 24
        targetSdk = 33
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        resources {
            excludes += "META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(project(":android:common:coroutines"))
    implementation(project(":android:common:sig"))
    implementation(project(":android:common:navigation"))
    implementation(project(":android:common:scoping"))
    implementation(project(":common:storekit"))

    implementation("com.google.android.gms:play-services-auth:20.4.1")

    implementation(libs.activity.compose)
    implementation(libs.androidx.viewmodel)
    implementation(libs.androidx.viewmodel.compose)
    implementation(libs.androidx.fragment)
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
    implementation(libs.compose.navigation)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.datastore.preferences)
}
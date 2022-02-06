plugins {
    id("com.android.application")
    kotlin("android")
}

val composeVersion = "1.0.5"

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "de.memorian.av.android"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        resourceConfigurations.add("de")
    }
    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
        }
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-rc02"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.appcompat:appcompat:1.4.1")

    // CameraX
    val cameraX = "1.0.2"
    implementation("androidx.camera:camera-camera2:$cameraX")
    implementation("androidx.camera:camera-lifecycle:$cameraX")
    implementation("androidx.camera:camera-view:1.0.0-alpha32")

    // MLKit
    implementation("com.google.mlkit:barcode-scanning:17.0.2")

    implementation(libs.koin.android)

    // Compose
    implementation("androidx.compose.ui:ui:$composeVersion")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    val material3Compose = "1.0.0-alpha03"
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.material3:material3:1.0.0-alpha04")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    // Integration with activities
    implementation("androidx.activity:activity-compose:1.4.0")
    // Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")
    // Navigation
    implementation("androidx.navigation:navigation-compose:2.4.0-rc01")

    implementation("io.coil-kt:coil-compose:1.4.0")
}
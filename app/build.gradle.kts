plugins {
    id("com.android.library")
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.satyasoft.composeuikits"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
      //  applicationId = "com.satyasoft.composeuikits"
        minSdk = 24
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // --------------------------
    // Core Android
    // --------------------------
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // --------------------------
    // Jetpack Compose (BOM)
    // --------------------------
    implementation(platform(libs.androidx.compose.bom))

    // Compose UI
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.foundation)

    // Tooling
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)

    // Animation
    implementation(libs.androidx.compose.animation)

    // UI Util
    implementation(libs.androidx.compose.ui.util)

    // Material3
    implementation(libs.androidx.material3)

    // Legacy Material (optional)
    implementation(libs.androidx.compose.material)

    // Icons
    implementation(libs.androidx.icons.core)
    implementation(libs.androidx.icons.ext)

    // Activity Compose
    implementation(libs.androidx.activity.compose)


    // Navigation Compose
    implementation(libs.androidx.navigation.compose)

    // Lifecycle + ViewModel Compose
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Coil (Image Loader)
    implementation(libs.coil.compose)

    // --------------------------
    // Kotlin Coroutines
    // --------------------------
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // --------------------------
    // Testing
    // --------------------------
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
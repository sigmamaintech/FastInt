plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.fastint"
    compileSdk = 34

    android {
        buildFeatures {
            dataBinding = true
            viewBinding = true
        }
    }

    defaultConfig {
        applicationId = "com.example.fastint"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildToolsVersion = "34.0.0"
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("androidx.navigation:navigation-ui:2.7.7")
    implementation(platform("com.google.firebase:firebase-bom:32.8.1"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation("com.google.firebase:firebase-database:20.3.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("com.google.firebase:firebase-appcheck-safetynet:16.0.0-beta01")
    //implementation ("com.github.barteksc:android-pdf-viewer:3.2.0-beta.1")
//    implementation ("com.google.firebase:firebase-storage:20.3.0") // Проверьте наличие последней версии
//    implementation ("androidx.core:core:1.12.0") // Проверьте наличие последней версии
//    implementation ("com.google.firebase:firebase-storage:latest_version")
//    implementation ("com.google.firebase:firebase-core:21.1.1")



//    implementation("androidx.room:room-compiler-processing-testing:2.6.1")
//    implementation("com.google.firebase:firebase-firestore:24.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}
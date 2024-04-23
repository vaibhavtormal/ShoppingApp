plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.vaibhav.shoppingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.vaibhav.shoppingapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        viewBinding {
            enable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    dependencies {
        implementation ("androidx.core:core-ktx:1.7.0")
        implementation ("androidx.appcompat:appcompat:1.4.0")
        implementation ("com.google.android.material:material:1.5.0")
        implementation ("androidx.activity:activity-ktx:1.3.1")
        implementation ("androidx.constraintlayout:constraintlayout:2.1.3")
        implementation ("com.google.firebase:firebase-database:20.0.2")
        implementation ("com.github.bumptech.glide:glide:4.12.0")
        implementation ("com.google.code.gson:gson:2.9.1")
        implementation ("com.tbuonomo:dotsindicator:5.0")


        // Testing dependencies
        testImplementation ("junit:junit:4.13.2")
        androidTestImplementation ("androidx.test.ext:junit:1.1.3")
        androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

        // Lifecycle components
        implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
        implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
        implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
        implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    }

}
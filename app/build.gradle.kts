plugins {
    id("com.android.application")
    //id("org.jetbrains.kotlin.android")
    kotlin("android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.horoscopoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.horoscopoapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            resValue("string", "fsamassa", "HoroscopoApp")
            buildConfigField("String","BASE_URL","\"https://newastro.vercel.app/\"")
            signingConfig = signingConfigs.getByName("debug")
        }
        getByName("debug") {
            isDebuggable = true
            resValue("string", "fsamassa", "[DEBUG] - HoroscopoApp")
            buildConfigField("String","BASE_URL","\"https://newastro-debug.vercel.app/\"")

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
    kotlin{
        jvmToolchain(8)
    }
}

dependencies {

    val navVersion = "2.7.1"
    val daggerHiltVersion = "2.48"
    val retroFitVersion = "2.9.0"
    val cameraVersion = "1.2.3"

    //NavigationComponent
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-compiler:$daggerHiltVersion")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retroFitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retroFitVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:4.3.1")

    //Camera X
    implementation ("androidx.camera:camera-core:${cameraVersion}")
    implementation ("androidx.camera:camera-camera2:${cameraVersion}")
    implementation ("androidx.camera:camera-lifecycle:${cameraVersion}")
    implementation ("androidx.camera:camera-view:${cameraVersion}")
    implementation ("androidx.camera:camera-extensions:${cameraVersion}")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Google Adds banner
    implementation("com.google.android.gms:play-services-ads:22.6.0")
    implementation("com.google.guava:guava:29.0-android") // Agrego esto para que no falle el getInstance de cameraX

}
plugins {
  id(Plugins.BuildPlugins.androidLib)
  id(Plugins.BuildPlugins.kotlinAndroid)
}


android {
  namespace = "com.google.android.fhir.document"
  compileSdk = Sdk.compileSdk

  defaultConfig {
    minSdk = Sdk.minSdk
    testInstrumentationRunner = Dependencies.androidJunitRunner
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  packaging { resources.excludes.addAll(listOf("META-INF/ASL-2.0.txt", "META-INF/LGPL-3.0.txt")) }

  kotlin { jvmToolchain(11) }
}

dependencies {

  implementation(Dependencies.Androidx.coreKtx)
  implementation(Dependencies.Androidx.appCompat)
  implementation(Dependencies.material)
  implementation(Dependencies.androidFhirEngine )

  // Barcode detector scanning
  implementation("com.google.zxing:core:3.4.1")
  implementation("com.google.android.gms:play-services-vision-common:20.1.3")
  implementation("com.google.android.gms:play-services-vision:20.1.3")

  // JWT decoding
  implementation("com.nimbusds:nimbus-jose-jwt:9.31")

  // TODO(hugomilosz): Remove this and use retrofit instead
  // implementation("com.google.firebase:firebase-crashlytics-buildtools:2.9.8")

  testImplementation(Dependencies.junit)
  androidTestImplementation(Dependencies.AndroidxTest.extJunit)
  androidTestImplementation(Dependencies.Espresso.espressoCore)
}
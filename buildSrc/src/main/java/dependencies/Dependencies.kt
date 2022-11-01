package dependencies

import Versions
import Versions.coroutines_version
import Versions.glide_version
import Versions.koin_version
import Versions.okhttp_version

object Dependencies {
   const val  kotlin_standard_library = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
   const val  kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
   const val  ktx = "androidx.core:core-ktx:${Versions.ktx}"
   const val  kotlin_coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_version}"
   const val  kotlin_coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}"
   const val  dagger = "com.google.dagger:dagger:${Versions.dagger}"
   const val  navigation_fragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.nav_components}"
   const val  navigation_runtime = "androidx.navigation:navigation-runtime:${Versions.nav_components}"
   const val  navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav_components}"
   const val  navigation_dynamic =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav_components}"
   const val  room_runtime = "androidx.room:room-runtime:${Versions.room}"
   const val  room_ktx = "androidx.room:room-ktx:${Versions.room}"
    var fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragment_ktx}"
   const val  lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle_version}"
   const val  lifecycle_coroutines =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
   const val  retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2_version}"
   const val  retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2_version}"
   const val  coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
   const val  coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"
   const val  okhttp = "com.squareup.okhttp3:okhttp:$okhttp_version"
   const val  okhttp_logging = "com.squareup.okhttp3:logging-interceptor:$okhttp_version"
   const val  koin = "io.insert-koin:koin-android:$koin_version"
   const val  glide = "com.github.bumptech.glide:$glide_version"
}
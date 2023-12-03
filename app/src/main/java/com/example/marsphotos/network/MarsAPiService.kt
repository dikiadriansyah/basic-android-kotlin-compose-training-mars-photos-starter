package com.example.marsphotos.network

import retrofit2.Retrofit
import retrofit2.http.GET

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

private const val BASE_URL= "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL).build()
// konstanta tersebut untuk membangun dan membuat objek Retrofit.

interface MarsApiService{
//     anotasi @GET untuk memberi tahu Retrofit bahwa ini adalah permintaan GET dan tentukan endpoint untuk metode layanan web. Dalam kasus ini, endpoint-nya adalah photos
    @GET("photos")
  suspend fun getPhotos(): List<MarsPhoto>
}

object MarsApi{
    val retrofitService: MarsApiService by lazy{
        retrofit.create(MarsApiService::class.java)
    }
}
//bjek ini adalah objek singleton publik yang dapat diakses oleh aplikasi lainnya.


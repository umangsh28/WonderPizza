package com.example.wonderpizza.Network

import com.example.wonderpizza.Api.Papi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
fun getRetrofit() =
    Retrofit.Builder()
        .baseUrl("https://run.mocky.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


fun getApiService() = getRetrofit().create(Papi::class.java)


}
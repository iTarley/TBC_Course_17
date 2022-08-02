package com.example.tbc_course_17.models

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object RetrofitClient {
    private const val BASE_URL = "https://run.mocky.io/v3/"
    private val retrofitBuilder by lazy{
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun getInformation(): NewsService = retrofitBuilder.create(NewsService::class.java)


}


interface NewsService{
    @GET("3588163c-a9c8-488c-af9a-534b392e7128")
    suspend fun getInfo(): Response<InfoModel>


}

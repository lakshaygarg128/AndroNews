package com.example.newsapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofithelper {
    private const val base_url = "https://newsapi.org"
    val instance =  Retrofit.Builder().baseUrl(base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsService::class.java)

}
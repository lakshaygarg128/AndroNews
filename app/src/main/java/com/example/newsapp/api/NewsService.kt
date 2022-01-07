package com.example.newsapp.api

import com.example.newsapp.models.NewsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/category")
    suspend fun getNews(@Query("category") category: String): Call<NewsList>
}
package com.example.newsapp.api

import com.example.newsapp.models.NewsList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/v2/top-headlines")
    suspend fun getNews(@Query("country") country : String="in",
                        @Query("category") category:String,
                        @Query("apiKey") API_KEY : String="fc1ecaee0c064fea84c3b4f452debe24"
    ): Response<NewsList>
}

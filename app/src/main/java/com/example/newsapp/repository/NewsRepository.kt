package com.example.newsapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.api.NewsService
import com.example.newsapp.api.retrofithelper
import com.example.newsapp.models.NewsList
import retrofit2.Response

class NewsRepository() {


    suspend fun getnews(category: String  ):Response<NewsList>{
        return retrofithelper.instance.getNews("in",category)
    }
}
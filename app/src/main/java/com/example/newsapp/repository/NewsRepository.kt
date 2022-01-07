package com.example.newsapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.api.NewsService
import com.example.newsapp.models.NewsList

class NewsRepository(private val NewsServices : NewsService) {
    private val Newdata = MutableLiveData<NewsList>()
    val News : LiveData<NewsList>
    get()=Newdata

    suspend fun getnews(category: String){
        val result= NewsServices.getNews(category)
        Newdata.postValue(result.)

    }
}
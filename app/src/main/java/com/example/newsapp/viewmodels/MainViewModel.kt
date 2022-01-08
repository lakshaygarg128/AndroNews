package com.example.newsapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.models.NewsList
import com.example.newsapp.repository.NewsRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: NewsRepository): ViewModel() {
    val all_News_Response : MutableLiveData<Response<NewsList>> = MutableLiveData()

    fun getNews(category: String){
        GlobalScope.launch {
            all_News_Response.postValue(repository.getnews(category))
        }
    }
}
package com.example.newsapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.newsapp.models.Article
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.viewmodels.MainViewModel
import com.example.newsapp.viewmodels.MainViewModelFactory

class MainActivity() : AppCompatActivity(), itemclicked{
    lateinit var viewmodel : MainViewModel
    private lateinit var  adapter :NewsAdapter
    var url = "https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json"
    var category = "general"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository=NewsRepository()
        viewmodel = ViewModelProvider(this,
            MainViewModelFactory(repository))
            .get(MainViewModel::class.java)
            checkurl()
        val categoryChoosen :TextView = findViewById(R.id.category_choosen)
        val Recyclerview : RecyclerView = findViewById(R.id.Recyclerview)
        categoryChoosen.text=category
        Recyclerview.layoutManager = LinearLayoutManager(this)
        viewmodel.getNews(category)
        viewmodel.all_News_Response.observe(this, Observer {
           Log.d("Response", it.body()!!.articles[0].title)
            adapter.updatenews(it.body()!!.articles as ArrayList<Article>)
        })

         adapter =NewsAdapter(this)
        Recyclerview.adapter=adapter
    }

    private fun checkurl() {
val type =intent.getStringExtra("type")
        when (type) {
            "1" -> {
                category = "general"
            }
            "2" -> {
                category = "entertainment"
            }
            "3" -> {
                category = "business"
            }
            "4" -> {
                category = "health"
            }
            "5" -> {
                category = "science"
            }
            "6" -> {
                category = "technology"
            }
            "7" -> {
                category = "sports"
            }
            else -> {

            }
        }
    }
    override fun onitemclicked(item: Article) {
        val url = item.url
        val builder =  CustomTabsIntent.Builder();
        val customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }

}
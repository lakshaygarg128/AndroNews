package com.example.newsapp

import android.app.DownloadManager
import android.app.VoiceInteractor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity() : AppCompatActivity(), itemclicked{
    private lateinit var  adapter :NewsAdapter
    var url = "https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkurl()
        val Recyclerview : RecyclerView = findViewById(R.id.Recyclerview)
        Recyclerview.layoutManager = LinearLayoutManager(this)
        fetchdata()
         adapter =NewsAdapter(this)
        Recyclerview.adapter=adapter
    }

    private fun checkurl() {
val type =intent.getStringExtra("type")
        when (type) {
            "1" -> url ="https://saurav.tech/NewsAPI/top-headlines/category/general/in.json"
            "2" -> url ="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json"
            "3" -> url ="https://saurav.tech/NewsAPI/top-headlines/category/business/in.json"
            "4" -> url ="https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
            "5" -> url ="https://saurav.tech/NewsAPI/top-headlines/category/science/in.json"
            "6" -> url ="https://saurav.tech/NewsAPI/top-headlines/category/technology/in.json"
            "7" -> url ="https://saurav.tech/NewsAPI/top-headlines/category/sports/in.json"
            else -> { // Note the block

            }
        }
    }

    private fun fetchdata() {
    val queue = Volley.newRequestQueue(this)


// Request a string response from the provided URL.
    val JsonObject = JsonObjectRequest(Request.Method.GET, url,null,
           Response.Listener {
                             val jsonObjectaraay = it.getJSONArray("articles")
               val newsarray = ArrayList<News>()
               for(i in 0 until jsonObjectaraay.length())
               {
                   val jsonObject = jsonObjectaraay.getJSONObject(i)
                   val news = News(
                           jsonObject.getString("title")
                   ,jsonObject.getString("author")
                   ,jsonObject.getString("url")
                   ,jsonObject.getString("urlToImage")
                   )
                   newsarray.add(news)
               }
                  adapter.updatenews(newsarray)

           },
            {
                   Toast.makeText(this,"(${it})",Toast.LENGTH_LONG).show()
            })
    queue.add(JsonObject)




}



    override fun onitemclicked(item: News) {
        val url = item.url
        val builder =  CustomTabsIntent.Builder();
        val customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }



}
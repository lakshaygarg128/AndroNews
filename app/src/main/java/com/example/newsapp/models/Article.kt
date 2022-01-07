package com.example.newsapp.models

data class Article(
    val author: String,
    val content: Any,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)
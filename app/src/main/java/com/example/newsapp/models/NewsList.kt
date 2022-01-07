package com.example.newsapp.models

data class NewsList(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
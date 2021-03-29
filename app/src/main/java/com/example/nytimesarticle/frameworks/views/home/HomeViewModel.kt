package com.example.nytimesarticle.frameworks.views.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val repository: HomeRepository = HomeRepository()

    init {
        getArticles()
    }

    private fun getArticles() {
        repository.getArticle()
    }

    fun getArticleResponse() = repository.articles
}
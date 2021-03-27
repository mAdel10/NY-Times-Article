package com.example.nytimesarticle.frameworks.views.articleProfile

import androidx.lifecycle.ViewModel

class ArticleViewModel : ViewModel() {

    private val repository: ArticleRepository = ArticleRepository()

    val id:String = ""

    init {
        getArticleProfile(id)
    }

     fun getArticleProfile(id : String) {
        repository.getArticlesProfile(id)
    }

    fun getArticleProfileResponse() = repository.profile
}
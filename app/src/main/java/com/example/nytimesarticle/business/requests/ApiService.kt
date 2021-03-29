package com.example.nytimesarticle.business.requests

import com.example.nytimesarticle.business.models.ArticleList
import com.example.nytimesarticle.business.models.Articles
import com.example.nytimesarticle.business.utils.constants.Constants
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.HOME)
    fun doGetArticles() : Call<ArticleList>

}
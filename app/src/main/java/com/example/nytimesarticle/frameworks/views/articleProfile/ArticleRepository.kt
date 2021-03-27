package com.example.nytimesarticle.frameworks.views.articleProfile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nytimesarticle.business.models.ArticleList
import com.example.nytimesarticle.business.models.Articles
import com.example.nytimesarticle.business.requests.ApiClient
import com.example.nytimesarticle.business.requests.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleRepository (val api : ApiService = ApiClient.apiService) {

    private val _profile = MutableLiveData<ArticleList>()
    val profile : LiveData<ArticleList> get() = _profile

    fun getArticlesProfile(id : String){
        api.doGetArticleProfile().enqueue(object : Callback<ArticleList>{
            override fun onResponse(call: Call<ArticleList>, response: Response<ArticleList>) {
                _profile.value = response.body()
            }

            override fun onFailure(call: Call<ArticleList>, t: Throwable) {
                val y = t
            }
        })

    }

}
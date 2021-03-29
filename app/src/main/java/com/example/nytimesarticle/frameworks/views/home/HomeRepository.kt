package com.example.nytimesarticle.frameworks.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nytimesarticle.business.models.ArticleList
import com.example.nytimesarticle.business.requests.ApiClient
import com.example.nytimesarticle.business.requests.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository (val api : ApiService = ApiClient.apiService) {


    private val _articles = MutableLiveData<ArticleList>()
    val articles : LiveData<ArticleList> get() = _articles

    fun getArticles(){
        api.doGetArticles().enqueue(object : Callback<ArticleList>{
            override fun onResponse(
                call: Call<ArticleList>,
                response: Response<ArticleList>
            ) {
                _articles.value = response.body()
            }

            override fun onFailure(call: Call<ArticleList>, t: Throwable) {
                val y = t
            }
        })
    }
}

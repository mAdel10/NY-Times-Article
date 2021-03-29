package com.example.nytimesarticle.frameworks.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nytimesarticle.business.models.ArticleList
import com.example.nytimesarticle.business.requests.ApiClient
import com.example.nytimesarticle.business.requests.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*

class HomeRepository (val api : ApiService = ApiClient.apiService) {


    private val _articles = MutableLiveData<ArticleList>()
    val articles : LiveData<ArticleList> get() = _articles

    fun getArticle(){
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.doGetArticle()
            if (response.isSuccessful){
                _articles.postValue(response.body())
            }
        }
    }

}

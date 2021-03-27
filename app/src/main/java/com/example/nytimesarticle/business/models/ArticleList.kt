package com.example.nytimesarticle.business.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ArticleList (
    @SerializedName("results")
     val articleList: List<Articles>) : Serializable

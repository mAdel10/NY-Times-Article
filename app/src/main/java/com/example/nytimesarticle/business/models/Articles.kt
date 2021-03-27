package com.example.nytimesarticle.business.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Articles(
    @SerializedName("id")
    val id: String,

    @SerializedName("section")
    val section: String,

    @SerializedName("byline")
    val authName: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("published_date")
    val published_date: String,

    @SerializedName("updated")
    val updated: String,

    @SerializedName("adx_keywords")
    val keywords: String,

    @SerializedName("abstract")
    val abstract: String,

    @SerializedName("uri")
    val articleLink: String,

    ) : Serializable
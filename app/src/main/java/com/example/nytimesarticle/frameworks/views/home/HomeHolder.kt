package com.example.nytimesarticle.frameworks.views.home

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesarticle.business.models.Articles
import com.example.nytimesarticle.databinding.ItemArticleBinding

class HomeHolder(private val binding: ItemArticleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Articles) {
        binding.articles = article
        binding.articlesCardView.setOnClickListener {
            Toast.makeText(itemView.context, "${article.title.toString()}", Toast.LENGTH_LONG)
                .show()
        }


    }
}
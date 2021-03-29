package com.example.nytimesarticle.frameworks.views.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesarticle.R
import com.example.nytimesarticle.business.models.Articles
import com.example.nytimesarticle.databinding.ItemArticleBinding

class HomeAdapter(private var articles: List<Articles>, val onImageClickListener: HomeAdapter.OnArticleClickListener) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemArticleBinding: ItemArticleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_article, parent, false
        )
        return ViewHolder(itemArticleBinding)
    }


    override fun getItemCount(): Int {
        return articles.size
    }

    fun setArticles (article: List<Articles>){
        articles = article
        notifyDataSetChanged()
    }


    inner class ViewHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindViews(article: Articles) {
            binding.articles = article
        }

    }

    interface OnArticleClickListener{
        fun onArticleClicked(article: Articles)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(articles[position])

        holder.binding.root.setOnClickListener {
            onImageClickListener.onArticleClicked(articles[position])
        }
    }

}
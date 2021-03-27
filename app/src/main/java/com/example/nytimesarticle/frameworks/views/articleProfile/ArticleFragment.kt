package com.example.nytimesarticle.frameworks.views.articleProfile

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.nytimesarticle.R.layout.fragment_article
import com.example.nytimesarticle.R.string.profile
import com.example.nytimesarticle.business.models.Articles
import com.example.nytimesarticle.databinding.FragmentArticleBinding
import com.example.nytimesarticle.frameworks.utils.ToolbarType.TEXT
import com.example.nytimesarticle.frameworks.views.base.BaseFragment

class ArticleFragment : BaseFragment<FragmentArticleBinding>() {


    override fun bindViews() {
        viewModel.UpdateToolbarType(TEXT)
        viewModel.UpdateToolbarName(getString(profile))

        getArticleDetails()
    }


    private fun getArticleDetails() {
//        binding.title.text = article.title
//        binding.section.text = article.section
//        binding.type.text = article.type
//        binding.Description.text = article.keywords
//        binding.publishedDate.text = article.published_date
//        binding.updateDate.text = article.updated
//        binding.articleLink.text = article.articleLink

        val title = arguments?.getString("title")
        val auth = arguments?.getString("auth")
        val section = arguments?.getString("section")
        val type = arguments?.getString("type")
        val Description = arguments?.getString("Description")
        val publishedDate = arguments?.getString("publishedDate")
        val updateDate = arguments?.getString("updateDate")
        val articleLink = arguments?.getString("articleLink")

        binding.title.text=title
        binding.authName.text=auth
        binding.section.text=section
        binding.type.text=type
        binding.Description.text=Description
        binding.publishedDate.text=publishedDate
        binding.updateDate.text=updateDate
        binding.articleLink.text=articleLink

    }

    override fun getLayoutResId() = fragment_article

}
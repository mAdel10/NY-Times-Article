package com.example.nytimesarticle.frameworks.views.home

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesarticle.R
import com.example.nytimesarticle.R.string.home
import com.example.nytimesarticle.business.models.Articles
import com.example.nytimesarticle.databinding.FragmentHomeBinding
import com.example.nytimesarticle.frameworks.utils.ToolbarType.TEXT
import com.example.nytimesarticle.frameworks.views.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(), HomeAdapter.OnArticleClickListener {

    private val homeViewModel by viewModels<HomeViewModel>()
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: HomeAdapter

    override fun bindViews() {
        viewModel.UpdateToolbarType(TEXT)
        viewModel.UpdateToolbarName(getString(home))
        subscribeOnObservers()
        initRecyclerView()
    }

    private fun subscribeOnObservers() {
        homeViewModel.getArticleResponse().observe(this, {

            adapter.setArticles(it.articleList)
        })
    }

    private fun initRecyclerView() {
        adapter = HomeAdapter(mutableListOf(), this)
        binding.recyclerView.adapter = adapter
        layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
    }

    override fun getLayoutResId() = R.layout.fragment_home


    override fun onArticleClicked(article: Articles) {

        val bundle = Bundle()
        bundle.putString("title", article.title)
        bundle.putString("auth", article.authName)
        bundle.putString("section", article.section)
        bundle.putString("type", article.type)
        bundle.putString("Description", article.keywords)
        bundle.putString("publishedDate", article.published_date)
        bundle.putString("updateDate", article.updated)
        bundle.putString("articleLink", article.articleLink)

        findNavController().navigate(R.id.toArticleFragment,bundle)

    }

}


package com.arysugiarto.dokutestandroid.ui.home

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.arysugiarto.dokutestandroid.R
import com.arysugiarto.dokutestandroid.data.remote.Result
import com.arysugiarto.dokutestandroid.databinding.FragmentHomeBinding
import com.arysugiarto.dokutestandroid.util.*
import com.arysugiarto.dokutestandroid.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding<FragmentHomeBinding>()
    private val viewModels by hiltNavGraphViewModels<HomeViewModel>(R.id.home)
    private val newsAdapter = HomeAdapter.newsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initCallback()

    }

    private fun initViewModel(){
        viewModels.requestNews()
    }

    private fun initCallback(){
        initNewsCallback()
        initClickAdapter()
    }

    private fun initNewsCallback() =
        viewModels.news.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> {

                }
                is Result.Success -> {
                    newsAdapter.items = result.data?.articles.orEmpty()

                }
                is Result.Error<*> -> {

                }
                else -> {
                }
            }
            binding.rvNews.adapter = newsAdapter

        }

    private fun initClickAdapter() {
        HomeAdapter.SetOnClickItem.setOnClickItemListener { item ->
            navController.navigateOrNull(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    item.title,
                    item.publishedAt,
                    item.content,
                    item.urlToImage,
                    item.description,
                    item.source?.name
                )
            )
        }
    }


}
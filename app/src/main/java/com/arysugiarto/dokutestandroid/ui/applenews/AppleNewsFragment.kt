package com.arysugiarto.dokutestandroid.ui.applenews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.arysugiarto.dokutestandroid.R
import com.arysugiarto.dokutestandroid.data.remote.Result
import com.arysugiarto.dokutestandroid.databinding.FragmentAppleNewsBinding
import com.arysugiarto.dokutestandroid.util.navController
import com.arysugiarto.dokutestandroid.util.navigateOrNull
import com.arysugiarto.dokutestandroid.util.viewBinding
import com.arysugiarto.dokutestandroid.viewmodel.AppleNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppleNewsFragment : Fragment(R.layout.fragment_apple_news) {

    private val binding by viewBinding<FragmentAppleNewsBinding>()
    private val viewModels by hiltNavGraphViewModels<AppleNewsViewModel>(R.id.apple)
    private val newsAdapter = AppleNewsAdapter.newsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initCallback()

    }

    private fun initViewModel() {
        viewModels.requestNews()
    }

    private fun initCallback() {
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
        AppleNewsAdapter.SetOnClickItem.setOnClickItemListener { item ->
            navController.navigateOrNull(
                AppleNewsFragmentDirections.actionAppleFragmentToDetailFragment(
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



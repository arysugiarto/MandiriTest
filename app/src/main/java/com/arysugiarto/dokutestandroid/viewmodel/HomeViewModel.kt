package com.arysugiarto.dokutestandroid.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.arysugiarto.dokutestandroid.data.remote.Result
import com.arysugiarto.dokutestandroid.base.BaseViewModel
import com.arysugiarto.dokutestandroid.data.remote.model.NewsResponse
import com.arysugiarto.dokutestandroid.data.repositories.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    homeRepository: HomeRepository
) : BaseViewModel(application) {
    private val repository = homeRepository

    private var _news: MutableLiveData<Result<NewsResponse>> = MutableLiveData()
    val news: LiveData<Result<NewsResponse>> get() = _news

    fun requestNews() =
        repository.requestNews()
            .onEach { result ->
                _news.value = result
            }.launchIn(viewModelScope)

}
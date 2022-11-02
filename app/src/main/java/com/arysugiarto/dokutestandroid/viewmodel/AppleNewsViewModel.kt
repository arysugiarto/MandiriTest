package com.arysugiarto.dokutestandroid.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.arysugiarto.dokutestandroid.data.remote.Result
import com.arysugiarto.dokutestandroid.base.BaseViewModel
import com.arysugiarto.dokutestandroid.data.remote.model.AppleNewsResponse
import com.arysugiarto.dokutestandroid.data.remote.model.NewsResponse
import com.arysugiarto.dokutestandroid.data.repositories.AppleNewsRepository
import com.arysugiarto.dokutestandroid.data.repositories.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AppleNewsViewModel @Inject constructor(
    application: Application,
    appleNewsRepository: AppleNewsRepository
) : BaseViewModel(application) {
    private val repository = appleNewsRepository

    private var _news: MutableLiveData<Result<AppleNewsResponse>> = MutableLiveData()
    val news: LiveData<Result<AppleNewsResponse>> get() = _news

    fun requestNews() =
        repository.requestNewsApple()
            .onEach { result ->
                _news.value = result
            }.launchIn(viewModelScope)

}
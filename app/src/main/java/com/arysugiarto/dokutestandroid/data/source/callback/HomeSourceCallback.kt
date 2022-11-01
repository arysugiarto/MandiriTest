package com.arysugiarto.dokutestandroid.data.source.callback

import com.arysugiarto.dokutestandroid.data.remote.Result
import com.arysugiarto.dokutestandroid.data.remote.model.NewsResponse
import kotlinx.coroutines.flow.Flow

interface HomeSourceCallback {
    fun requestNews(
    ): Flow<Result<NewsResponse>>
}
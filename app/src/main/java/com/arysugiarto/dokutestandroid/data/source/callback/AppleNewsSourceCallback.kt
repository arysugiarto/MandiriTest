package com.arysugiarto.dokutestandroid.data.source.callback

import com.arysugiarto.dokutestandroid.data.remote.Result
import com.arysugiarto.dokutestandroid.data.remote.model.AppleNewsResponse
import com.arysugiarto.dokutestandroid.data.remote.model.NewsResponse
import kotlinx.coroutines.flow.Flow

interface AppleNewsSourceCallback {
    fun requestNewsApple(
    ): Flow<Result<AppleNewsResponse>>
}
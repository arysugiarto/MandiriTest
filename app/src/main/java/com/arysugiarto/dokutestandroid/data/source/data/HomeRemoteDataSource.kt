package com.arysugiarto.dokutestandroid.data.source.data

import com.arysugiarto.dokutestandroid.data.remote.api.ApiCallback
import com.arysugiarto.dokutestandroid.util.flowResponse

class HomeRemoteDataSource(callback: ApiCallback) {
    private val apiCallback = callback

    fun requestNewsDataSource() =
        flowResponse {
            apiCallback.requestNews()
        }

}
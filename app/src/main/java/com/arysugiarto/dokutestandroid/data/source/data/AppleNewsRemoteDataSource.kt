package com.arysugiarto.dokutestandroid.data.source.data

import com.arysugiarto.dokutestandroid.data.remote.api.ApiCallback
import com.arysugiarto.dokutestandroid.util.flowResponse

class AppleNewsRemoteDataSource(callback: ApiCallback) {
    private val apiCallback = callback

    fun requestNewsAppleDataSource() =
        flowResponse {
            apiCallback.requestAppleNews()
        }

}
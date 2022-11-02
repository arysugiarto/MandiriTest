package com.arysugiarto.dokutestandroid.data.repositories

import com.arysugiarto.dokutestandroid.data.source.callback.AppleNewsSourceCallback
import com.arysugiarto.dokutestandroid.data.source.callback.HomeSourceCallback
import com.arysugiarto.dokutestandroid.data.source.data.AppleNewsRemoteDataSource
import com.arysugiarto.dokutestandroid.data.source.data.HomeRemoteDataSource

class AppleNewsRepository(
    appleRemoteDataSource: AppleNewsRemoteDataSource
) : AppleNewsSourceCallback {
    private val remoteDataSource = appleRemoteDataSource

    override fun requestNewsApple() = remoteDataSource.requestNewsAppleDataSource()

}
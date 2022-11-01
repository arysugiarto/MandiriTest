package com.arysugiarto.dokutestandroid.data.repositories

import com.arysugiarto.dokutestandroid.data.source.callback.HomeSourceCallback
import com.arysugiarto.dokutestandroid.data.source.data.HomeRemoteDataSource

class HomeRepository(
    homeRemoteDataSource: HomeRemoteDataSource
) : HomeSourceCallback {
    private val remoteDataSource = homeRemoteDataSource

    override fun requestNews() = remoteDataSource.requestNewsDataSource()

}
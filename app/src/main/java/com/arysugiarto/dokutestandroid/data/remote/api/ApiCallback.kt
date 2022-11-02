package com.arysugiarto.dokutestandroid.data.remote.api

import com.arysugiarto.dokutestandroid.data.remote.model.AppleNewsResponse
import com.arysugiarto.dokutestandroid.data.remote.model.NewsResponse
import com.arysugiarto.dokutestandroid.util.Const
import retrofit2.Response
import retrofit2.http.GET

interface ApiCallback {

    @GET(Const.NETWORK.News)
    suspend fun requestNews(
    ): Response<NewsResponse>

    @GET(Const.NETWORK.AppleNews)
    suspend fun requestAppleNews(
    ): Response<AppleNewsResponse>

}

package com.arysugiarto.dokutestandroid.data.di

import android.app.Application
import android.content.Context
import com.google.android.play.core.review.ReviewManagerFactory
import com.arysugiarto.dokutestandroid.data.preferences.AccessManager
import com.arysugiarto.dokutestandroid.data.remote.api.ApiCallback
import com.arysugiarto.dokutestandroid.data.repositories.AppleNewsRepository
import com.arysugiarto.dokutestandroid.data.repositories.HomeRepository
import com.arysugiarto.dokutestandroid.data.source.data.AppleNewsRemoteDataSource
import com.arysugiarto.dokutestandroid.data.source.data.HomeRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class])
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    fun provideApplication(application: Application): Context = application

    @Singleton
    @Provides
    fun provideAccessManager(context: Context) = AccessManager(context)

    @Provides
    @Singleton
    fun provideReviewManager(@ApplicationContext context: Context) =
        ReviewManagerFactory.create(context)

    @Provides
    fun provideHomeRepository(
        apiCallback: ApiCallback
    ) = HomeRepository(
        HomeRemoteDataSource(apiCallback)
    )

    @Provides
    fun provideAppleNewsRepository(
        apiCallback: ApiCallback
    ) = AppleNewsRepository(
        AppleNewsRemoteDataSource(apiCallback)
    )

}
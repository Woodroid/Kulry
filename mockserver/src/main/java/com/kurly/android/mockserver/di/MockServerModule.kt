package com.kurly.android.mockserver.di

import android.content.Context
import com.kurly.android.mockserver.MockInterceptor
import com.kurly.android.mockserver.MockServer
import com.kurly.android.mockserver.core.AssetFileProvider
import com.kurly.android.mockserver.core.FileProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MockServerModule {

    @Provides
    fun provideMockInterceptor(@ApplicationContext context: Context): MockInterceptor {
        return MockInterceptor(context)
    }

}
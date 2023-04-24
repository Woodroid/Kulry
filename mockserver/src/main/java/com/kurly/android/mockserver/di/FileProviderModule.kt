package com.kurly.android.mockserver.di

import android.content.Context
import com.kurly.android.mockserver.core.AssetFileProvider
import com.kurly.android.mockserver.core.FileProvider
import com.kurly.android.mockserver.core.TestAssetFileProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FileProviderModule {

    @Provides
    @Singleton
    internal fun provideFileProvider(@ApplicationContext context: Context): FileProvider {
        return AssetFileProvider(context)
    }

    @Provides
    @Singleton
    internal fun provideTestFileProvider(): TestAssetFileProvider {
        return TestAssetFileProvider()
    }

}
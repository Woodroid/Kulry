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
import javax.inject.Qualifier
import javax.inject.Singleton

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class AssetFileProviderForReal

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class AssetFileProviderForTest

@Module
@InstallIn(SingletonComponent::class)
object FileProviderModule {

    @Provides
    @Singleton
    @AssetFileProviderForReal
    internal fun provideFileProvider(@ApplicationContext context: Context): FileProvider {
        return AssetFileProvider(context)
    }

    @Provides
    @Singleton
    @AssetFileProviderForTest
    internal fun provideTestFileProvider(): FileProvider {
        return TestAssetFileProvider()
    }

}
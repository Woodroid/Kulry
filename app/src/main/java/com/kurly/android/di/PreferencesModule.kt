package com.kurly.android.di

import android.content.Context
import com.kurly.android.presentation.prefs.ProductSharedPreference
import com.kurly.android.presentation.prefs.ProductSharedPreferenceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Provides
    @Singleton
    fun provideProductSharedPreferences(@ApplicationContext context: Context): ProductSharedPreference {
        return ProductSharedPreferenceImpl(context)
    }

}
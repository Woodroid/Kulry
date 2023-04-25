package com.kurly.android.di

import com.kurly.android.domain.repository.PagingRepository
import com.kurly.android.domain.usecase.SectionWithProductsUseCase
import com.kurly.android.domain.usecase.SectionWithProductsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideSectionWithProductsUseCase(repository: PagingRepository): SectionWithProductsUseCase {
        return SectionWithProductsUseCaseImpl(repository)
    }

}
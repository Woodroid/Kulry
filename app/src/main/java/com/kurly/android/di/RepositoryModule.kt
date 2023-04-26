package com.kurly.android.di

import com.kurly.android.data.paging.SectionsWithProductPagingSource
import com.kurly.android.data.remote.ApiServer
import com.kurly.android.data.remote.repository.PagingRepositoryImpl
import com.kurly.android.domain.repository.PagingRepository
import com.kurly.android.domain.repository.SectionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSectionRepository(apiServer: ApiServer): SectionRepository {
        return com.kurly.android.data.remote.repository.SectionRepositoryImpl(apiServer)
    }

    @Provides
    @Singleton
    fun providePagingRepository(repository: SectionRepository): PagingRepository {
        return PagingRepositoryImpl(repository)
    }

}
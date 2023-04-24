package com.kulry.data.di

import com.kulry.data.paging3.SectionsWithProductPagingSource
import com.kulry.data.remote.ApiServer
import com.kulry.data.repository.SectionRepository
import com.kulry.data.repository.SectionRepositoryImpl
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
        return SectionRepositoryImpl(apiServer)
    }

    @Provides
    @Singleton
    fun provideSectionWithProductPagingSource(repository: SectionRepository): SectionsWithProductPagingSource {
        return SectionsWithProductPagingSource(repository)
    }

}
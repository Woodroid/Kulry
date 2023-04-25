package com.kurly.android.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kurly.android.data.model.SectionWithProduct
import com.kurly.android.data.paging.SectionsWithProductPagingSource
import com.kurly.android.domain.repository.PagingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PagingRepositoryImpl @Inject constructor(private val pagingSource: SectionsWithProductPagingSource):
    PagingRepository {

    override fun getSectionWithProductFlow(): Flow<PagingData<SectionWithProduct>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { pagingSource }
        ).flow
    }

    companion object {
        const val PAGE_SIZE = 20
    }

}
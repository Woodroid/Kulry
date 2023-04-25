package com.kurly.android.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.kurly.android.data.model.SectionWithProduct
import com.kurly.android.domain.repository.PagingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class SectionWithProductsUseCaseImpl @Inject constructor(private val pagingRepository: PagingRepository):
    SectionWithProductsUseCase {

    companion object {
        private const val NETWORK_PAGE_SIZE = 20
    }

    override suspend fun invoke(): Result<Flow<PagingData<SectionWithProduct>>> {
        val sectionWithProductFlow = pagingRepository.getSectionWithProductFlow()
        sectionWithProductFlow.single()
        return sectionWithProductFlow.let {
            Result.success(it)
        }
    }
}
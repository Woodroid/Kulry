package com.kurly.android.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.kurly.android.data.model.SectionWithProduct
import com.kurly.android.domain.repository.PagingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SectionWithProductsUseCaseImpl @Inject constructor(private val pagingRepository: PagingRepository) :
    SectionWithProductsUseCase {

    override suspend fun invoke(): Flow<PagingData<SectionWithProduct>> = pagingRepository.getSectionWithProductFlow()
}
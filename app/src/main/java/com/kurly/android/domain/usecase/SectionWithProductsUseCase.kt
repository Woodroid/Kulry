package com.kurly.android.domain.usecase

import androidx.paging.PagingData
import com.kurly.android.data.model.SectionWithProduct
import kotlinx.coroutines.flow.Flow

interface SectionWithProductsUseCase {

    suspend operator fun invoke(): Result<Flow<PagingData<SectionWithProduct>>>

}
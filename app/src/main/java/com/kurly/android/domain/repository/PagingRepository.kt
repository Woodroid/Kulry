package com.kurly.android.domain.repository

import androidx.paging.PagingData
import com.kurly.android.data.model.SectionWithProduct
import kotlinx.coroutines.flow.Flow

interface PagingRepository {

    fun getSectionWithProductFlow(): Flow<PagingData<SectionWithProduct>>

}
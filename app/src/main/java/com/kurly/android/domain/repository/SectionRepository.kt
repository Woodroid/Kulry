package com.kurly.android.domain.repository

import com.kurly.android.data.remote.response.ProductResponse
import com.kurly.android.data.remote.response.SectionResponse

interface SectionRepository {

    suspend fun getSections(page: Int): Result<SectionResponse>

    suspend fun getSectionProducts(id: String): Result<ProductResponse>

}
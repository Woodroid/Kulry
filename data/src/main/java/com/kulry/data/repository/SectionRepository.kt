package com.kulry.data.repository

import com.kulry.data.data.ProductResponse
import com.kulry.data.data.SectionResponse
import retrofit2.Response

interface SectionRepository {

    suspend fun getSections(page: Int): Result<SectionResponse>

    suspend fun getSectionProducts(id: String): Result<ProductResponse>

}
package com.kulry.data.repository

import com.kulry.data.data.ProductResponse
import com.kulry.data.data.SectionResponse
import com.kulry.data.remote.ApiServer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class SectionRepositoryImpl @Inject constructor(private val apiServer: ApiServer): SectionRepository {

    override suspend fun getSections(page: Int): Result<SectionResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiServer.getSections(page = page)
                if (response.isSuccessful) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(HttpException(response))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    override suspend fun getSectionProducts(id: String): Result<ProductResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiServer.getProducts(sectionId = id)
                if (response.isSuccessful) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(HttpException(response))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

}
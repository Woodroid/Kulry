package com.kurly.android.data.remote.repository

import android.util.Log
import com.kurly.android.data.remote.ApiServer
import com.kurly.android.data.remote.response.ProductResponse
import com.kurly.android.data.remote.response.SectionResponse
import com.kurly.android.domain.repository.SectionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class SectionRepositoryImpl @Inject constructor(private val apiServer: ApiServer):
    SectionRepository {

    override suspend fun getSections(page: Int): Result<SectionResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiServer.getSections(page = page)
                if (response.isSuccessful) {
                    Log.d("woo", "getSections Success ${page}")
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
                    Log.d("woo", "getProducts Success ${id}")
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
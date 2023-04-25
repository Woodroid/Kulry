package com.kurly.android.data.remote

import com.kurly.android.data.remote.response.ProductResponse
import com.kurly.android.data.remote.response.SectionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServer {

    @GET("/sections")
    suspend fun getSections(@Query("page") page: Int): Response<SectionResponse>

    @GET("/section/products")
    suspend fun getProducts(@Query("sectionId") sectionId: String): Response<ProductResponse>

}
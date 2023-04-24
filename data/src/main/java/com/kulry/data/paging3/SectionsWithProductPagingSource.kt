package com.kulry.data.paging3

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kulry.data.data.Section
import com.kulry.data.data.SectionResponse
import com.kulry.data.data.SectionWithProduct
import com.kulry.data.remote.ApiServer
import com.kulry.data.repository.SectionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SectionsWithProductPagingSource @Inject constructor(
    private val repository: SectionRepository
) : PagingSource<Int, SectionWithProduct>() {

    override fun getRefreshKey(state: PagingState<Int, SectionWithProduct>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SectionWithProduct> {
        return try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 1
            val sections = repository.getSections(nextPageNumber).getOrThrow()

            val sectionWithProducts = sections.data.map {
                val products = repository.getSectionProducts(it.id).getOrThrow().products

                SectionWithProduct(
                    id = it.id,
                    title = it.title,
                    type = it.type,
                    url = it.url,
                    products = products
                )
            }

            val prevKey = null
            val nextKey = sections.paging.nextPage

            LoadResult.Page(
                data = sectionWithProducts,
                prevKey = prevKey, // Only paging forward.
                nextKey = nextKey
            )
        } catch (e: Exception) {
            // Handle errors in this block and return LoadResult.Error if it is an
            // expected error (such as a network failure).
            LoadResult.Error(e)
        }
    }

}
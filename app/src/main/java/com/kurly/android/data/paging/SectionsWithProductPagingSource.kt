package com.kurly.android.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kurly.android.data.model.Product
import com.kurly.android.data.model.SectionWithProduct
import com.kurly.android.domain.repository.SectionRepository
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
            val sectionsResult = repository.getSections(nextPageNumber)
            val sections = sectionsResult.getOrThrow().data

            // Fetch all products for all sections in one call.
            val productDataMap = mutableMapOf<String, List<Product>>()
            sections.forEach { section ->
                val productsResult = repository.getSectionProducts(section.id)
                val products = productsResult.getOrThrow().products
                productDataMap[section.id] = products
            }

            val sectionWithProducts = sections.map { section ->
                SectionWithProduct(
                    id = section.id,
                    title = section.title,
                    type = section.type,
                    url = section.url,
                    products = productDataMap[section.id] ?: emptyList()
                )
            }
            val prevKey = if (nextPageNumber > 1) nextPageNumber - 1 else null
            val nextKey = sectionsResult.getOrThrow().paging.nextPage

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
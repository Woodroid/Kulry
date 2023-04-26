package com.kurly.android.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kurly.android.data.model.SectionWithProduct
import com.kurly.android.domain.usecase.SectionWithProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val sectionWithProductsUseCase: SectionWithProductsUseCase): ViewModel() {

    suspend fun getSectionWithProducts(): Flow<PagingData<SectionWithProduct>> {
        return sectionWithProductsUseCase().cachedIn(viewModelScope)
    }

    override fun onCleared() {
        super.onCleared()
    }
}
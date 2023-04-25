package com.kurly.android.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kurly.android.data.model.SectionWithProduct
import com.kurly.android.domain.usecase.SectionWithProductsUseCase
import com.kurly.android.presentation.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val sectionWithProductsUseCase: SectionWithProductsUseCase): ViewModel() {

    val uiStateLiveData = MutableLiveData<UIState<Flow<PagingData<SectionWithProduct>>>>()

    fun getSectionWithProducts() {
        viewModelScope.launch {
            uiStateLiveData.value = UIState.Loading
            val result = sectionWithProductsUseCase()
            result.fold(
                onSuccess = { flow ->
                    uiStateLiveData.value = UIState.Success(flow)
                },
                onFailure = { exception ->
                    uiStateLiveData.value = UIState.Error(exception)
                }
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}
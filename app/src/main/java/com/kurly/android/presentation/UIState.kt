package com.kurly.android.presentation

sealed class UIState<out T> {
    object Loading : UIState<Nothing>()
    data class Success<T>(val data: T) : UIState<T>()
    data class Error(val throwable: Throwable) : UIState<Nothing>()
}

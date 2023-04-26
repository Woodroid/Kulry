package com.kurly.android.presentation.prefs

interface ProductSharedPreference {
    fun isProductLike(productId: String): Boolean
    fun setProductLike(productId: String, favorite: Boolean)
}
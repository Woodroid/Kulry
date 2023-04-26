package com.kurly.android.presentation.prefs

import android.content.Context

class ProductSharedPreferenceImpl(context: Context) : ProductSharedPreference {

    private val sharedPreferences = context.getSharedPreferences("like_products", Context.MODE_PRIVATE)

    override fun isProductLike(productId: String): Boolean {
        return sharedPreferences.getBoolean(productId, false)
    }

    override fun setProductLike(productId: String, favorite: Boolean) {
        sharedPreferences.edit().putBoolean(productId, favorite).apply()
    }
}
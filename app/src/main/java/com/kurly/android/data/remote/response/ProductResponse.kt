package com.kurly.android.data.remote.response

import com.google.gson.annotations.SerializedName
import com.kurly.android.data.model.Product

data class ProductResponse(@SerializedName("data") val products: List<Product>)
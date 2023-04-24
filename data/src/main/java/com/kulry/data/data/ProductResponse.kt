package com.kulry.data.data

import com.google.gson.annotations.SerializedName

data class ProductResponse(@SerializedName("data") val products: List<Product>)

package com.kurly.android.data.model

import com.google.gson.annotations.SerializedName

data class Product(@SerializedName("id") val id: String,
                   @SerializedName("name") val name: String,
                   @SerializedName("image") val image: String,
                   @SerializedName("originalPrice") val originalPrice: Int,
                   @SerializedName("discountedPrice") val discountedPrice: Int?,
                   @SerializedName("isSoldOut") val isSoldOut: Boolean)
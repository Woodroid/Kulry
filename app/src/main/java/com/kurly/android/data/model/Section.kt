package com.kurly.android.data.model

import com.google.gson.annotations.SerializedName

data class Section(@SerializedName("title") val title: String,
                   @SerializedName("id") val id: String,
                   @SerializedName("type") val type: String,
                   @SerializedName("url") val url: String)
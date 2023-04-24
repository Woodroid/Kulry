package com.kulry.data.data

import com.google.gson.annotations.SerializedName

data class SectionResponse(@SerializedName("data") val data: List<Section>,
                           @SerializedName("paging") val paging: Paging)

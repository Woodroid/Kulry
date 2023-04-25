package com.kurly.android.data.remote.response

import com.google.gson.annotations.SerializedName
import com.kurly.android.data.model.Paging
import com.kurly.android.data.model.Section

data class SectionResponse(@SerializedName("data") val data: List<Section>,
                           @SerializedName("paging") val paging: Paging
)
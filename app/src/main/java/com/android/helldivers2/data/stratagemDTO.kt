package com.android.helldivers2.data

import com.google.gson.annotations.SerializedName

data class StratagemResponse(
    @SerializedName("data") val data: StratagemData,
    @SerializedName("error") val error: String
)

data class StratagemData(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)

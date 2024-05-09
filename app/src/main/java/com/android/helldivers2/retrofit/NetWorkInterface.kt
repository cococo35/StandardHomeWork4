package com.android.helldivers2.retrofit

import com.android.helldivers2.data.StratagemResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface NetWorkInterface {
    @GET("/api/stratagems/{id}")
    suspend fun getSearch(@Path("id") id: Int): StratagemResponse
}
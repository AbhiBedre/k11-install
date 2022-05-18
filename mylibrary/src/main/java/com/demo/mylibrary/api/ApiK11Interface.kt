package com.demo.mylibrary.api

import com.demo.mylibrary.model.ApiResponse
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiK11Interface {

    @POST("gameService/checkUpdateAvailable")
    fun getK11ApiCall(
        @Body data: JsonElement
    ): Call<ApiResponse>
}
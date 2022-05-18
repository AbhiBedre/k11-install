package com.demo.mylibrary

import android.util.Log
import com.demo.mylibrary.model.ApiResponse
import com.demo.mylibrary.retrofilt.RetrofitClient
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallK11Api {
    companion object {
        fun registerApi(param: String = "", productId: String = "KAPTAIN11", apiCallback: (ApiResponse?, String?) -> Unit) {
            RetrofitClient.instance?.let {
                val jsonObject = JsonObject()
                jsonObject.addProperty("currentVersion", param)
                jsonObject.addProperty("productId", productId)
                val call: Call<ApiResponse> = it.getK11Api().getK11ApiCall(jsonObject)
                call.enqueue(object : Callback<ApiResponse> {
                    override fun onResponse(
                        call: Call<ApiResponse>?,
                        response: Response<ApiResponse>
                    ) {
                        val apiResponse: ApiResponse? = response.body()
                        if (apiResponse != null) {
                            apiCallback(apiResponse, "")
                        } else {
                            apiCallback(null, "")
                        }
                    }

                    override fun onFailure(call: Call<ApiResponse>?, t: Throwable?) {
                        Log.i("TAG", "onFailure: ${t?.message}")
                        apiCallback(null, t?.message)
                    }
                })
            }
        }
    }
}
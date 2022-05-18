package com.demo.mylibrary.retrofilt

import com.demo.mylibrary.api.ApiK11Interface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient private constructor() {
    private val k11Api: ApiK11Interface
    fun getK11Api(): ApiK11Interface {
        return k11Api
    }

    companion object {
        @get:Synchronized
        var instance: RetrofitClient? = null
            get() {
                if (field == null) {
                    field = RetrofitClient()
                }
                return field
            }
            private set
    }

    private val BASE_URL = "https://k11api.kaptain11.com/"
    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        k11Api = retrofit.create(ApiK11Interface::class.java)
    }
}
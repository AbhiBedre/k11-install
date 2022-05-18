package com.demo.mylibrary.model

data class ApiResponse(
    val success: Boolean,
    val errorCode: Int,
    val description: String
)
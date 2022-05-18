package com.demo.kotlinlab

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.demo.mylibrary.CallK11Api

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callK11Api()
    }

    private fun callK11Api() {
        CallK11Api.registerApi("5.27") { apiResponse, message ->
            Log.i("TAG", "callK11Api: $apiResponse")
            Log.i("TAG", "callK11Api: $message")
        }
    }
}
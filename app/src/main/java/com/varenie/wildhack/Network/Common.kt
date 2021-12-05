package com.varenie.wildhack.Network

object Common {
    private val BASE_URL = "http://172.24.181.239:8080/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}
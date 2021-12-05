package com.varenie.wildhack.Network

import com.varenie.wildhack.Database.Entities.FirstForm
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @POST("api")
    fun uploadData(@Body firstForm: FirstForm): Call<ResponseBody>
}
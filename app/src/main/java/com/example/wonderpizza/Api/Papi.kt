package com.example.wonderpizza.Api

import com.example.wonderpizza.Modal.Crust
import com.example.wonderpizza.Modal.ResponseDTO
import com.example.wonderpizza.Modal.Size
import retrofit2.Call
import retrofit2.http.GET

interface Papi {
   //https://run.mocky.io/v3/02c35a6b-1c33-4c6e-b488-eedbc9eb5ead
    @GET("v3/02c35a6b-1c33-4c6e-b488-eedbc9eb5ead")
    fun getPizza(): Call<ResponseDTO>


    @GET("v3/02c35a6b-1c33-4c6e-b488-eedbc9eb5ead")
    fun getPizza1(): Call<ResponseDTO>
}
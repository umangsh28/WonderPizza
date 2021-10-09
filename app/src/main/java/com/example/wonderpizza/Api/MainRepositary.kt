package com.example.wonderpizza.Api


import com.example.wonderpizza.Modal.ResponseDTO
import com.example.wonderpizza.Network.Network

import retrofit2.Call
import retrofit2.Response

class MainRepositary {

     fun getAll() : Call<ResponseDTO>{
        return Network.getApiService().getPizza()
    }

}
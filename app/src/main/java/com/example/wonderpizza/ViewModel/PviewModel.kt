package com.example.mvvmbyllyod.ViewModel

import android.content.Context
import android.provider.Settings
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import com.example.wonderpizza.Api.MainRepositary
import com.example.wonderpizza.Modal.ResponseDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.IO_PARALLELISM_PROPERTY_NAME
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PviewModel : ViewModel() {

    private val mainRepositary= MainRepositary()
     val mutableLiveaData=MutableLiveData<ResponseDTO>()

    val livedata:LiveData<ResponseDTO> get() = mutableLiveaData

      fun callapi(){


          mainRepositary.getAll().enqueue(object : Callback<ResponseDTO>{
              override fun onResponse(p0: Call<ResponseDTO>, response: Response<ResponseDTO>){
                  val res:ResponseDTO=response.body()!!
                  mutableLiveaData.value=res


              }

              override fun onFailure(p0: Call<ResponseDTO>, p1: Throwable){
                  Log.d("Tag",p1.message.toString())


              }


          })


    }


}
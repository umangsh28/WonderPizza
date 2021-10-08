package com.example.wonderpizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wonderpizza.Api.Papi
import com.example.wonderpizza.Interface.OnPizzaClick
import com.example.wonderpizza.Modal.ResponseDTO
import com.example.wonderpizza.Network.Network
import com.example.wonderpizza.Recycler.Padapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_design.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),OnPizzaClick {

    var responseDTO:ResponseDTO?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        apiCalling()



    }

    private fun bottomButton() {
       showBottomSheet()
    }

    private fun showBottomSheet() {
       var bottomSheetDialog=BottomSheetDialog(this)
       bottomSheetDialog.setContentView(R.layout.crust_design)


        bottomSheetDialog.show()
    }


    private fun apiCalling() {
        val APIclientF = Network.getretro().create(Papi::class.java)

        APIclientF.getBook().enqueue(object : Callback<ResponseDTO> {
            override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                responseDTO = response.body()
                SetRecycler()
            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun SetRecycler() {
        val adapterbusiness = Padapter(responseDTO!!,this)
        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = adapterbusiness
        recycler.layoutManager = linearLayoutManager
    }

    override fun OnItemClick(responseDTO: ResponseDTO, pos: Int) {
        super.OnItemClick(responseDTO, pos)
        Toast.makeText(this,"hiiiii",Toast.LENGTH_LONG).show()
        bottomButton()


    }


}
package com.example.wonderpizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmbyllyod.ViewModel.PviewModel
import com.example.wonderpizza.Api.Papi
import com.example.wonderpizza.Interface.OnPizzaClick
import com.example.wonderpizza.Modal.Crust
import com.example.wonderpizza.Modal.ResponseDTO
import com.example.wonderpizza.Modal.Size
import com.example.wonderpizza.Network.Network
import com.example.wonderpizza.Recycler.Padapter
import com.example.wonderpizza.Recycler.SecondPage.Badapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.crust_design.*
import kotlinx.android.synthetic.main.item_design.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity(),OnPizzaClick {

    var responseDTO:ResponseDTO?=null
    var responseDTO2: List<Size>?=null
    private lateinit var mainViewModel: PviewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        apiCalling()



    }





    /////mvvm
    private fun apiCalling() {
       mainViewModel=ViewModelProvider(this).get(PviewModel::class.java)

        mainViewModel.callapi()

        mainViewModel.livedata.observe(this,{
            it?.let{
                responseDTO=it
            }
            SetRecycler()
        })

    }

    private fun SetRecycler() {
        val adapterbusiness = Padapter(responseDTO!!,this)
        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = adapterbusiness
        recycler.layoutManager = linearLayoutManager
    }

    ///bottomsheet
    private fun bottomButton() {
        showBottomSheet()
    }

    private fun showBottomSheet() {
        var bottomSheetDialog=BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.crust_design)


        val BottomAdapter= Badapter(responseDTO!!)
        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        var recyclerr=bottomSheetDialog.findViewById<RecyclerView>(R.id.recyclerBottom)
        recyclerr!!.adapter = BottomAdapter
        recyclerr.layoutManager = linearLayoutManager

        bottomSheetDialog.show()


    }



    ///clicklistener
    override fun OnItemClick(responseDTO: ResponseDTO, pos: Int) {
        super.OnItemClick(responseDTO, pos)
        Toast.makeText(this,"hiiiii",Toast.LENGTH_LONG).show()
        bottomButton()


    }




}
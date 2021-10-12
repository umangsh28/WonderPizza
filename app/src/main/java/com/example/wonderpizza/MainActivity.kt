package com.example.wonderpizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmbyllyod.ViewModel.PviewModel
import com.example.wonderpizza.BottomSheet.Companion.TAG
import com.example.wonderpizza.Interface.OnPizzaClick
import com.example.wonderpizza.Modal.ResponseDTO
import com.example.wonderpizza.Recycler.FirstPage.Padapter
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.crust_design.*
import kotlinx.android.synthetic.main.item_design.*
import java.util.*

class MainActivity : AppCompatActivity(),OnPizzaClick {

    var responseDTO:ResponseDTO?=null

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
    private fun bottomButton(pos:Int) {
        showBottomSheet(pos)
    }

    private fun showBottomSheet(pos:Int) {
        var bottomSheetDialog=BottomSheet()

        bottomSheetDialog.show(supportFragmentManager,"ModalBottomSheet")

    }



    ///clicklistener
    override fun OnItemClick(responseDTO: ResponseDTO, pos: Int) {
        Toast.makeText(this,"hiiiii",Toast.LENGTH_LONG).show()

        bottomButton(pos)

        val bundle=Bundle()

        bundle.putString("pizaname",responseDTO.crusts.get(pos).sizes.get(pos).name)

        bundle.putString("pizaprice", responseDTO.crusts.get(pos).sizes.get(pos).price.toString())

        val frag=Fragment()
        frag.arguments=bundle

    }


}
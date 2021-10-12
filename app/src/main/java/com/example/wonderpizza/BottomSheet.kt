package com.example.wonderpizza

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmbyllyod.ViewModel.PviewModel
import com.example.wonderpizza.Api.Papi
import com.example.wonderpizza.Interface.OnCalClick
import com.example.wonderpizza.Interface.OnPizzaClick
import com.example.wonderpizza.Modal.Crust
import com.example.wonderpizza.Modal.ResponseDTO
import com.example.wonderpizza.Modal.Size
import com.example.wonderpizza.Network.Network
import com.example.wonderpizza.Recycler.FirstPage.Pholder
import com.example.wonderpizza.Recycler.SecondPage.Badapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.crust_design.*
import kotlinx.android.synthetic.main.item_crust.*
import retrofit2.Call
import retrofit2.Response

class BottomSheet : BottomSheetDialogFragment(), OnCalClick{

    private lateinit var mainViewModel: PviewModel
    var responseDTO1:ResponseDTO? = null




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.crust_design, container, false)

    companion object{
        const val TAG = "ModalBottomSheet"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)






        ini()


        Bcart.setOnClickListener {
            dataToCart()
        }



    }

    private fun ini() {
        val apic = Network.getRetrofit().create(Papi::class.java)

        apic.getPizza1()
            .enqueue(object : retrofit2.Callback<ResponseDTO>{
                override fun onResponse(p0: Call<ResponseDTO>, p1: Response<ResponseDTO>) {
                    responseDTO1=p1.body()
                    setrecycler()
                }

                override fun onFailure(p0: Call<ResponseDTO>, p1: Throwable) {
                    Toast.makeText(context,p1.message, Toast.LENGTH_LONG).show()
                }
            })





    }


    private fun setrecycler() {
        val BottomAdapter= Badapter(responseDTO1!!,this)
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerBottom!!.adapter = BottomAdapter
        recyclerBottom.layoutManager = linearLayoutManager
    }

    var count=0;
    var count1=0
    var name=""
    var sum=0;
    var sum1=0;
    var sum2=0

    override fun OnBottomClick(responseDTO: Crust, pos: Int) {

        TCount.text="${++count}"



        if(crustName.text.equals(responseDTO.sizes.get(pos).name)){
            count1=count
        }
        name=responseDTO.sizes.get(pos).name


        sum += responseDTO.sizes.get(pos).price.toInt()
        Bamt.text="₹${sum}"
        sum1=sum

    }

    override fun OnBottomClickMin(responseDTO: Crust, pos: Int) {


        if(count!=0 || sum!=0 || sum<0) {
            sum -= responseDTO.sizes.get(pos).price.toInt()
            TCount.text = "${--count}"

            Bamt.text = "₹${sum}"
            sum2=sum
        }else{
            Toast.makeText(context,"please add item",Toast.LENGTH_SHORT).show()
        }

        if(count==0){
            sum=0
            Bamt.text="0"
        }

    }


    fun dataToCart(){

        val i=Intent(context,Cart::class.java)

        i.putExtra("namepizza",name)

        i.putExtra("sumprice",sum)

        i.putExtra("pcount",count1)

        startActivity(i)

    }




}

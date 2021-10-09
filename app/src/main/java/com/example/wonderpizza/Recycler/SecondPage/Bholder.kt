package com.example.wonderpizza.Recycler.SecondPage

import android.content.Context
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import com.example.wonderpizza.Interface.OnPizzaClick
import com.example.wonderpizza.Modal.Crust
import com.example.wonderpizza.Modal.ResponseDTO
import com.example.wonderpizza.Modal.Size
import com.example.wonderpizza.R
import kotlinx.android.synthetic.main.crust_design.view.*
import kotlinx.android.synthetic.main.item_crust.view.*

class Bholder(var itemView: View):RecyclerView.ViewHolder(itemView) {

    fun setData(responseDTO: Crust, pos:Int) {

        val PizzaName1= itemView.findViewById<TextView>(R.id.crustName)
        PizzaName1.text= responseDTO.sizes.get(adapterPosition).name
        val PizzaPrice1= itemView.findViewById<TextView>(R.id.pizzaPrice)
        PizzaPrice1.text="₹${responseDTO.sizes.get(adapterPosition).price}"

//        var count=1;
//        var sum=0;
//        val countele= itemView.findViewById<TextView>(R.id.TCount)
//        val amount= itemView.findViewById<TextView>(R.id.Bamt)
//        var PizzaAdd= itemView.findViewById<ImageButton>(R.id.checkPlus)
//        PizzaAdd.setOnClickListener {
//
////            countele.text="${++count}"
//            amount.text="${sum+responseDTO.sizes.get(adapterPosition).price}"
//        }
//        var PizzaMin= itemView.findViewById<ImageButton>(R.id.checkMin)
//        PizzaMin.checkMin.setOnClickListener {
//            if(count!=0){
////                countele.text="${--count}"
//                amount.text="${sum-responseDTO.sizes.get(adapterPosition).price}"
//            }else{
//                Toast.makeText(itemView.context,"Please add something",Toast.LENGTH_SHORT).show()
//            }
//        }


    }





}
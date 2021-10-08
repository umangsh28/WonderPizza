package com.example.wonderpizza.Recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wonderpizza.Modal.Crust
import com.example.wonderpizza.Modal.ResponseDTO
import com.example.wonderpizza.R
import kotlinx.android.synthetic.main.item_design.*

class Pholder(var itemView: View) :RecyclerView.ViewHolder(itemView) {



    fun setData(responseDTO: ResponseDTO){

       var PizzaName= itemView.findViewById<TextView>(R.id.Pname)
       PizzaName.text=responseDTO.name

       var isVeg=responseDTO.isVeg
       var HallMark=itemView.findViewById<ImageView>(R.id.Pboolean)

       if(isVeg.equals("true")){
           Glide.with(HallMark.context).load(R.drawable.isveg).into(HallMark)
       }else{
           Glide.with(HallMark.context).load(R.drawable.isnonveg).into(HallMark)
       }

       var Pimage=itemView.findViewById<ImageView>(R.id.PImg)
        Glide.with(Pimage.context).load(R.drawable.pimages).into(Pimage)

       var PizzaDesc=itemView.findViewById<TextView>(R.id.Pdes)
        PizzaDesc.text=responseDTO.description



    }



}
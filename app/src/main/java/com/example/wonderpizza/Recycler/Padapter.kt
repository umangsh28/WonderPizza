package com.example.wonderpizza.Recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wonderpizza.Interface.OnPizzaClick
import com.example.wonderpizza.Modal.Crust
import com.example.wonderpizza.Modal.ResponseDTO
import com.example.wonderpizza.Modal.Size
import com.example.wonderpizza.R

class Padapter() : RecyclerView.Adapter<Pholder>() {

    private var responseDTO : ResponseDTO?=null
    private var ClickListener:OnPizzaClick?=null


    constructor(responseDTO: ResponseDTO,ClickListener:OnPizzaClick) : this() {
        this.responseDTO=responseDTO
        this.ClickListener=ClickListener

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pholder {
       return  Pholder(LayoutInflater.from(parent.context).inflate(R.layout.item_design,parent,false),ClickListener!!)
    }

    override fun onBindViewHolder(holder: Pholder, position: Int) {
        var responseDTO: ResponseDTO = responseDTO!!
        holder.setData(responseDTO,ClickListener!!)

    }

    override fun getItemCount(): Int {
       return responseDTO!!.crusts.size
    }
}
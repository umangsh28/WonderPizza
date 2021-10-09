package com.example.wonderpizza.Recycler.SecondPage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wonderpizza.Interface.OnPizzaClick
import com.example.wonderpizza.Modal.Crust
import com.example.wonderpizza.Modal.ResponseDTO
import com.example.wonderpizza.Modal.Size
import com.example.wonderpizza.R
import com.example.wonderpizza.Recycler.FirstPage.Pholder

class Badapter() :RecyclerView.Adapter<Bholder>() {

    private var responseDTO : ResponseDTO?=null
//    private var ClickListener: OnPizzaClick?=null


    constructor(responseDTO: ResponseDTO ) : this() {
        this.responseDTO=responseDTO
//        this.ClickListener=ClickListener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Bholder {
        return  Bholder(LayoutInflater.from(parent.context).inflate(R.layout.item_crust,parent,false))
    }

    override fun onBindViewHolder(holder: Bholder, pos: Int) {
        var responseDTO: Crust = responseDTO!!.crusts[pos]
        holder.setData(responseDTO,pos)
    }

    override fun getItemCount(): Int {
        return responseDTO!!.crusts.size
    }

}
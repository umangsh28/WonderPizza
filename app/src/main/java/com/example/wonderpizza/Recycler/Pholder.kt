package com.example.wonderpizza.Recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.wonderpizza.Modal.Crust
import com.example.wonderpizza.Modal.ResponseDTO
import kotlinx.android.synthetic.main.item_design.*

class Pholder(var itemView: View) :RecyclerView.ViewHolder(itemView) {

    fun setData(responseDTO: Crust){
        Pname.text=responseDTO.name
    }



}
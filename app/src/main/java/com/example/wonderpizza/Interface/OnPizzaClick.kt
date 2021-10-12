package com.example.wonderpizza.Interface

import com.example.wonderpizza.Modal.Crust
import com.example.wonderpizza.Modal.ResponseDTO

interface OnPizzaClick {
    fun OnItemClick(responseDTO: ResponseDTO,pos:Int)





}

interface OnCalClick{
    fun OnBottomClick(responseDTO: Crust, pos:Int)

    fun OnBottomClickMin(responseDTO: Crust, pos:Int)
}
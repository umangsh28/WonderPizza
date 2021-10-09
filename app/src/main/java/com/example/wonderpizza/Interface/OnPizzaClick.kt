package com.example.wonderpizza.Interface

import com.example.wonderpizza.Modal.ResponseDTO

interface OnPizzaClick {
    fun OnItemClick(responseDTO: ResponseDTO,pos:Int){}

    fun OnBottomClick(responseDTO: ResponseDTO,pos:Int){}



}
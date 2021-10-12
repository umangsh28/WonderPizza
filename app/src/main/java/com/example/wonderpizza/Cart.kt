package com.example.wonderpizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cart.*

class Cart : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)


        val name1=intent.getStringExtra("namepizza")

        val price=intent.getIntExtra("sumprice",0)

        val count=intent.getStringExtra("pcount")


        cartname.text="$name1 pizza"
        cartprice.text= price.toString()

    }
}
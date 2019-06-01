package com.example.mudraapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_refer_earn.*

class ReferEarn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refer_earn)

        whatsapp.setOnClickListener {

            val i= Intent()
            i.action=Intent.ACTION_SEND
            i.putExtra( Intent.EXTRA_TEXT , "Hello , I'am using Mudra App")
            i.setPackage("com.whatsapp")
            startActivity(i)
        }


    }
}

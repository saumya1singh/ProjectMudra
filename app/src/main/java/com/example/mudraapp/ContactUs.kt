package com.example.mudraapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contact_us.*


class ContactUs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        letsconnect.setOnClickListener {
            startActivity(Intent( baseContext, ContactUsForm::class.java ))
        }
    }
}

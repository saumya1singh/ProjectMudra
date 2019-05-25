package com.example.mudraapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_options.*

class OptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)
        checkcredit.setOnClickListener {

            startActivity(Intent(baseContext, CheckScore::class.java))
        }

        becomepartner.setOnClickListener {
            startActivity(Intent(baseContext ,CheckOnlineLoans::class.java ))
        }
    }
}

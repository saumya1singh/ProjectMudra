package com.example.mudraapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        tvHome.setOnClickListener {
            startActivity(Intent(baseContext, MainActivity::class.java))
        }
        tvContact.setOnClickListener {
            startActivity(Intent(baseContext, ContactUs::class.java))
        }
        tvKnowledge.setOnClickListener {
            startActivity(Intent(baseContext, KnowledgeCenter::class.java))
        }
        tvLogout.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirm Logout")
            builder.setMessage("Are you sure you want to logout?")
            builder.setPositiveButton("LOGOUT") { _, _ ->

                startActivity(Intent(this, WelcomeActivity::class.java))
                finishAffinity()
            }
            builder.setNegativeButton("CANCEL") { dialog, _ ->
                dialog.cancel()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

package com.example.mudraapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apply.setOnClickListener {
            startActivity(Intent(baseContext, ApplyActivity::class.java))
        }
        click.setOnClickListener {

            startActivity(Intent( baseContext , OptionsActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.menus , menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            R.id.a -> {
                startActivity(Intent(baseContext,MainActivity::class.java ))
            }
            R.id.b -> {
                startActivity(Intent(baseContext, CheckOnlineLoans::class.java))
            }
            R.id.c -> {
                startActivity(Intent(baseContext, KnowledgeCenter::class.java ))
            }
            R.id.d -> {
                startActivity(Intent(baseContext, ContactUs::class.java))
            }


        }
        return true
    }
}

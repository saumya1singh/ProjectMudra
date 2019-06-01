package com.example.mudraapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var animate: Animation
    private var home = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animate = AnimationUtils.loadAnimation(this, R.anim.animate)
        btn.animation = animate

        apply.setOnClickListener {
            startActivity(Intent(baseContext, ApplyActivity::class.java))
        }
        click.setOnClickListener {

            startActivity(Intent(baseContext, OptionsActivity::class.java))
        }
        btnmenu.setOnClickListener {
            startActivity(Intent(baseContext, MenuActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.a -> {
                startActivity(Intent(baseContext, MainActivity::class.java))
            }
            R.id.b -> {
               supportFragmentManager.beginTransaction().replace(R.id.main, OnlineLoansFrag() ).commit()
            }
            R.id.c -> {
                startActivity(Intent(baseContext, KnowledgeCenter::class.java))
            }
            R.id.d -> {
                startActivity(Intent(baseContext, ContactUs::class.java))
            }


        }
        return true

    }

    override fun onBackPressed() {
        if (!home)
            MainActivity()
        else {
            super.onBackPressed()
        }
    }

}

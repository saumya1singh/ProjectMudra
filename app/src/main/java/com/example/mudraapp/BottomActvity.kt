package com.example.mudraapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bottom_actvity.*
import kotlinx.android.synthetic.main.activity_bottom_actvity.apply
import kotlinx.android.synthetic.main.activity_bottom_actvity.btnmenu
import kotlinx.android.synthetic.main.activity_bottom_actvity.click
import kotlinx.android.synthetic.main.activity_main.*

class BottomActvity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.navigation_home -> {

                startActivity(Intent(baseContext , MainActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.omline_loans-> {
                val fragment =OnlineLoansFrag()
                  supportFragmentManager.beginTransaction().replace(R.id.container , fragment).addToBackStack(null).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.credit -> {
                startActivity(Intent(baseContext , CheckScore::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.homeloan->{
                val fragment =HomeLoanFrag()
                supportFragmentManager.beginTransaction().replace(R.id.container , fragment ).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.sc->{
                val fragment=MyAccountFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container , MyAccountFragment()).addToBackStack("My Account").commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_actvity)

        apply.setOnClickListener {
            startActivity(Intent(baseContext, ApplyActivity::class.java))
        }
        click.setOnClickListener {

            startActivity(Intent(baseContext, OptionsActivity::class.java))
        }
        btnmenu.setOnClickListener {
            startActivity(Intent(baseContext, MenuActivity::class.java))
        }
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}

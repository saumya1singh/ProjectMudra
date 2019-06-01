package com.example.mudraapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_bottom_actvity.*
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.nav_header_navigation.*
import kotlin.apply

class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.navigation_home -> {

                startActivity(Intent(baseContext, MainActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.omline_loans -> {
                val fragment = OnlineLoansFrag()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.credit -> {
                startActivity(Intent(baseContext, CheckScore::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.homeloan -> {
//                val fragment =HomeLoanFrag()
//                supportFragmentManager.beginTransaction().replace(R.id.container , fragment ).commit()
                startActivity(Intent(baseContext , ReferEarn::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.sc -> {
                val fragment = MyAccountFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, MyAccountFragment()).addToBackStack("My Account").commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        nav_view.setNavigationItemSelectedListener(this)

        FirebaseApp.initializeApp(baseContext)
//        usermobile.text = FirebaseAuth.getInstance().currentUser?.phoneNumber.toString()
        apply.setOnClickListener {
            startActivity(Intent(baseContext, ApplyActivity::class.java))
        }
        click.setOnClickListener {
            startActivity(Intent(baseContext, OptionsActivity::class.java))
        }
        btnmenu.setOnClickListener {
            startActivity(Intent(baseContext, MenuActivity::class.java))
        }
        navigationmenu.setOnClickListener {
            //  nav_view.display
            if (!drawer_layout.isDrawerOpen(GravityCompat.START))
                drawer_layout.openDrawer(Gravity.START)
            else
                drawer_layout.closeDrawer(Gravity.END)

        }
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    //ActionBar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

    //ActionBar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        when (item.itemId) {
//            R.id.action_settings -> return true
//            else -> return super.onOptionsItemSelected(item)
//        }
        return super.onOptionsItemSelected(item)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                startActivity(Intent(baseContext, BottomActvity::class.java))

            }
            R.id.nav_account -> {

                supportFragmentManager.beginTransaction().replace(R.id.myid, MyAccountFragment()).commit()
            }
            R.id.nav_credit -> {

                startActivity(Intent(baseContext, CheckScore::class.java))

            }
            R.id.nav_rewards -> {

                startActivity(Intent(baseContext, ReferEarn::class.java))

            }
            R.id.nav_calculator -> {

                startActivity(Intent(baseContext, EMIcalculator::class.java))
            }
            R.id.nav_selfie -> {

                startActivity(Intent(baseContext, SelfieActivity::class.java))

            }
            R.id.btnlogout -> {
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

            R.id.btnabout -> {
                startActivity(Intent(baseContext, KnowledgeCenter::class.java))
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}

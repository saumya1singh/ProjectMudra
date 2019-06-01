package com.example.mudraapp

import android.app.Activity
import android.content.Intent
import android.os.Handler
import com.firebase.ui.auth.AuthUI
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_welcome.*
import java.util.*

class WelcomeActivity : AppCompatActivity() {
    private var m: Handler? = null
    private val USER_LOCATION_REQUEST_CODE = 1000
    private val SPLASH_LENGHT: Long = 500000L
    private lateinit var animate: Animation
    val firebaseUser = FirebaseAuth.getInstance().currentUser
    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {

            val i = Intent(baseContext, MainActivity::class.java)
            startActivity(i)
            finish()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val animate = AnimationUtils.loadAnimation(this, R.anim.animate)
        f.animation = animate
        m = Handler()
        m!!.postDelayed(mRunnable
                , SPLASH_LENGHT)

        FirebaseApp.initializeApp(this)

        linear.setOnClickListener {
            val firebaseUser = FirebaseAuth.getInstance().currentUser
            if (firebaseUser != null) {
                startActivity(Intent(baseContext, NavigationActivity::class.java))
            } else {
                //launching signin intent
                startActivityForResult(AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setIsSmartLockEnabled(true)
                        .setAvailableProviders(Arrays.asList(AuthUI.IdpConfig.PhoneBuilder().build(), AuthUI.IdpConfig.GoogleBuilder().build(), AuthUI.IdpConfig.EmailBuilder().build()))
                        .build(), USER_LOCATION_REQUEST_CODE)

            }
        }
    }

    public override fun onDestroy() {

        if (m != null) {
            m!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == USER_LOCATION_REQUEST_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                //successfully signed in
                startActivity(Intent(baseContext,NavigationActivity::class.java))
            } else {
                if (response == null)
                    return
                // if (response.error!!.errorCode == ErrorCodes.NO_NETWORK)
                //   return
            }
        }
    }
}

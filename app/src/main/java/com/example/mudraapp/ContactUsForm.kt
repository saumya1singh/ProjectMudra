package com.example.mudraapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_contact_us_form.*

class ContactUsForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us_form)
        FirebaseApp.initializeApp(applicationContext)
        val firebaseUser = FirebaseAuth.getInstance().currentUser
        val userId = firebaseUser?.uid.toString()
        Log.e("UID", userId)
        val dbref = FirebaseDatabase.getInstance().reference


        send.setOnClickListener {
            val username = name.text.toString()
            val loanamount = amount.text.toString()
            val type = type.text.toString()
            val mobile = phone.text.toString()
            val mailid = mail.text.toString()
            val yourcity = city.text.toString()
            val occup = occupation.text.toString()

            val rootnode = dbref.child(userId)
            val name = rootnode.child("User Name").push().setValue(username)
            val b = rootnode.child("Loan Amount").push().setValue(loanamount)
            val c = rootnode.child("Loan Type").push().setValue(type)
            val d = rootnode.child("Mobile Number").push().setValue(mobile)
            val e = rootnode.child("Email-id").push().setValue(mailid)
            val f = rootnode.child("City").push().setValue(yourcity)
            val g = rootnode.child("Occupation").push().setValue(occup)

            Toast.makeText(baseContext, "Thankyou for contacting us, we will get back to you soon ❤  ", Toast.LENGTH_LONG)

        }


    }
}

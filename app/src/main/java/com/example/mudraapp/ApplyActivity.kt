package com.example.mudraapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_apply.*
import kotlinx.android.synthetic.main.activity_check_score.*
import kotlinx.android.synthetic.main.activity_contact_us_form.*
import java.sql.Date

class ApplyActivity : AppCompatActivity() {

    lateinit var option: Spinner
    lateinit var result: TextView
    lateinit var employe: Spinner
    lateinit var tvemp: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)
        option = findViewById<Spinner>(R.id.spinnertype)
        result = findViewById<TextView>(R.id.tvtype)
        employe = findViewById<Spinner>(R.id.spinneremploye)
        tvemp = findViewById(R.id.tvemployee)


        val employee = arrayOf("SELECT EMPLOYEE TYPE", "SALARIED")
        val b = ArrayAdapter(this, android.R.layout.simple_spinner_item, employee)
        b.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        employe.adapter = b
        employe.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                tvemp.text = "please select"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tvemp.text = employee.get(position)
            }

        }

        val genderlist = arrayOf("SELECT GENDER", "MALE", "FEMALE")
        val c = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderlist)
        c.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinnergender.adapter = c
        spinnergender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                tvgender.text = "please select"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tvgender.text = genderlist[position]
            }

        }

        val datelist= arrayOf("SELECT DOB DATE","1" ,"2","3","4")
        val d=ArrayAdapter(this,android.R.layout.simple_spinner_item, datelist)
        d.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinnerdobd.adapter=d
        spinnerdobd.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

                tvdobd.text="please select"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                tvdobd.text=datelist.get(position)
            }

        }
        val monthlist= arrayOf("SELECT DOB MONTH","1" ,"2","3","4")
        val e=ArrayAdapter(this,android.R.layout.simple_spinner_item,monthlist)
        e.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinnerdobm.adapter=e
        spinnerdobd.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

                tvdobm.text="please select"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                tvdobm.text=monthlist.get(position)
            }

        }
        val yearlist= arrayOf("SELECT DOB YEAR","1" ,"2","3","4")
        val f=ArrayAdapter(this,android.R.layout.simple_spinner_item,yearlist)
        f.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinnerdoby.adapter=f
        spinnerdoby.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

                tvdoby.text="please select"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                tvdoby.text=yearlist.get(position)
            }

        }

        val loan_types = arrayOf("SELECT LOAN TYPE ", "BALANCE TRANSFER", "BUSINESS LOAN", "HOME LOAN", "LOAN AGAINST PROPERTY", "PERSONAL LOAN")
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, loan_types)
        aa.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
//        webview.settings.javaScriptEnabled=true
//        webview.settings.cacheMode= WebSettings.LOAD_CACHE_ELSE_NETWORK
//        webview.settings.cacheMode = WebSettings.LOAD_NO_CACHE
//
//        webview.webViewClient= object : WebViewClient(){
//            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//                view?.loadUrl(url)
//                return true
//            }
//
//
//            override fun onPageFinished(view: WebView?, url: String?) {
//                super.onPageFinished(view, url)
//                progressBar1.visibility=View.GONE
//            }
//        }
//        webview.loadUrl("https://www.mudrahome.com/loan-ligibility-calc
        option.adapter = aa
        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "PLease select one option"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                result.text = loan_types.get(position)
            }

        }

        btnnext.setOnClickListener {
            FirebaseApp.initializeApp(applicationContext)
            val firebaseUser = FirebaseAuth.getInstance().currentUser
            val userId = firebaseUser?.uid.toString()
            Log.e("UID", userId)
            val dbref = FirebaseDatabase.getInstance().reference



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

           startActivity(Intent(baseContext, ApplyIntent::class.java ))
        }
    }


}


package com.example.mudraapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_apply.*
import kotlinx.android.synthetic.main.activity_check_score.*

class ApplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

        webview.settings.javaScriptEnabled=true
        webview.settings.cacheMode= WebSettings.LOAD_CACHE_ELSE_NETWORK
        webview.settings.cacheMode = WebSettings.LOAD_NO_CACHE

        webview.webViewClient= object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }


            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar1.visibility=View.GONE
            }
        }
        webview.loadUrl("https://www.mudrahome.com/loan-ligibility-calculator")

    }

    }


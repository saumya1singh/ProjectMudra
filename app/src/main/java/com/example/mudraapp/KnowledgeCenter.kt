package com.example.mudraapp

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_knowledge_center.*

class KnowledgeCenter : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knowledge_center)

        myweb.settings.cacheMode=WebSettings.LOAD_CACHE_ELSE_NETWORK
        myweb.webViewClient =object : WebViewClient (){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {

                view?.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                progress.visibility=View.GONE
            }
        }
        myweb.loadUrl("https://www.mudrahome.com/blog/")
    }
}

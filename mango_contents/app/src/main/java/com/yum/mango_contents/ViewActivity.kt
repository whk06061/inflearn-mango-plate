package com.yum.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val item = intent.getSerializableExtra("item") as ContentsModel
        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl(item.url)

        findViewById<TextView>(R.id.tv_save).setOnClickListener {
            // Write a message to the database
            val database = Firebase.database
            val bookmarkRef = database.getReference("bookmark")

            auth = Firebase.auth
            bookmarkRef.child(auth.currentUser!!.uid).push().setValue(item)
        }

    }
}
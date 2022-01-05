package com.yum.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private val contentsModels = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        val database = Firebase.database
        val bookmarkRef = database.getReference("bookmark")

        auth = Firebase.auth

        val recyclerview = findViewById<RecyclerView>(R.id.rv_bookmark)
        val rvAdapter = RVAdapter(baseContext, contentsModels)
        recyclerview.adapter = rvAdapter
        recyclerview.layoutManager = GridLayoutManager(this, 2)

        // Read from the database
        bookmarkRef.child(auth.currentUser!!.uid)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    for (dataModel in dataSnapshot.children) {
                        val data = dataModel.getValue<ContentsModel>()
                        contentsModels.add(data!!)
                        //Log.d("bookmarkresult", data.toString())
                    }
                    //Log.d("bookmarkresult", "success")
                    rvAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("bookmarkresult", error.toString())
                }
            })

    }
}
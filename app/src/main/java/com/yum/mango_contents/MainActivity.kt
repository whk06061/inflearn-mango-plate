package com.yum.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tv_bookmark).setOnClickListener {
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/Gk7QsMOVDs",
                "https://mp-seoul-image-production-s3.mangoplate.com/185802/epp-yngymd-zjj.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "오스틴"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/w8C71rPEoR7d",
                "https://mp-seoul-image-production-s3.mangoplate.com/320817/83687_1501749339157_21354?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "뉴타운"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/iXobcHXQf6",
                "https://mp-seoul-image-production-s3.mangoplate.com/192543/1042666_1631854671316_29936?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "북천"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/dqL32F-fFBqa",
                "https://mp-seoul-image-production-s3.mangoplate.com/396209/920411_1640876850975_14820?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "러시아케익"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/Gk7QsMOVDs",
                "https://mp-seoul-image-production-s3.mangoplate.com/185802/epp-yngymd-zjj.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "오스틴"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/w8C71rPEoR7d",
                "https://mp-seoul-image-production-s3.mangoplate.com/320817/83687_1501749339157_21354?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "뉴타운"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/iXobcHXQf6",
                "https://mp-seoul-image-production-s3.mangoplate.com/192543/1042666_1631854671316_29936?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "북천"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/dqL32F-fFBqa",
                "https://mp-seoul-image-production-s3.mangoplate.com/396209/920411_1640876850975_14820?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "러시아케익"
            )
        )
        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, items)
        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("item", items[position])
                startActivity(intent)
            }

        }
        recyclerview.adapter = rvAdapter
        recyclerview.layoutManager = GridLayoutManager(this, 2)
    }
}
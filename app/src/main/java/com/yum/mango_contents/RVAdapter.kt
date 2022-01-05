package com.yum.mango_contents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RVAdapter(val context: Context, val List: MutableList<ContentsModel>) :
    RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(v)
    }

    //클릭 인터페이스 정의
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    //클릭 리스너 선언
    var itemClick: ItemClick? = null

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        if (itemClick != null) {
            holder?.itemView.setOnClickListener { v ->
                itemClick!!.onClick(v, position)
            }
        }
        holder.bindItems(List[position])
    }

    override fun getItemCount(): Int {
        return List.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: ContentsModel) {

            val iv = itemView.findViewById<ImageView>(R.id.iv_food)
            val tv = itemView.findViewById<TextView>(R.id.tv_title)

            tv.text = item.titleText
            //인터넷 url로 이미지 설정하기
            Glide.with(context).load(item.imageUrl).into(iv)
        }

    }
}
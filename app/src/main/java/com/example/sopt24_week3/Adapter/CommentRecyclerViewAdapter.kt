package com.example.sopt24_week3.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sopt24_week3.Data.CommentData
import com.example.sopt24_week3.R

class CommentRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<CommentData>):RecyclerView.Adapter<CommentRecyclerViewAdapter.Holder>() {
    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx)
            .load(dataList[position].author)
            .into(holder.img_thumbnail)
        holder.author.text = dataList[position].author
        holder.comment.text = dataList[position].comment
        holder.publish_date.text = dataList[position].publish_date
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_comment,p0,false)
        return Holder(view)
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        var container = itemView.findViewById(R.id.ll_rv_item_comment_container) as LinearLayout
        var img_thumbnail = itemView.findViewById(R.id.img_rv_item_comment_thumbnail) as ImageView
        var author = itemView.findViewById(R.id.txt_rv_item_comment_author) as TextView
        var comment = itemView.findViewById(R.id.txt_rv_item_comment_comment) as TextView
        var publish_date = itemView.findViewById(R.id.txt_rv_item_comment_date) as TextView
    }
}
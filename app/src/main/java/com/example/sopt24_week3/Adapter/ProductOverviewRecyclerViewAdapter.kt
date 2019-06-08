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
import com.example.sopt24_week3.Activity.ProductActivity
import com.example.sopt24_week3.Data.ProductOverviewData
import com.example.sopt24_week3.R
import org.jetbrains.anko.startActivity

class ProductOverviewRecyclerViewAdapter(val ctx:Context, var datalist: ArrayList<ProductOverviewData>): RecyclerView.Adapter<ProductOverviewRecyclerViewAdapter.Holder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view:View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_product_overview,p0,false)
        return Holder(view)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        Glide.with(ctx)
            .load(datalist[p1].thumbnail)
            .into(p0.img_thumnail)

        p0.title.text = datalist[p1].title
        p0.author.text = datalist[p1].name
        p0.num_like.text = datalist[p1].likes.toString()
        p0.container.setOnClickListener {
            ctx.startActivity<ProductActivity>(
                "idx" to datalist[p1].idx,
                "title" to datalist[p1].title
            )
        }

    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        // class안에 class를 정의 하는 것이므로 inner를 붙여줌
        var container = itemView.findViewById(R.id.ll_rv_item_product_overview_container) as LinearLayout
        var img_thumnail = itemView.findViewById(R.id.img_rv_item_product_overview_thumbnail) as ImageView
        var title = itemView.findViewById(R.id.txt_rv_item_product_overview_title) as TextView
        var author = itemView.findViewById(R.id.txt_rv_item_product_overview_author) as TextView
        var num_like = itemView.findViewById(R.id.txt_rv_item_product_overview_numlike) as TextView
    }
}
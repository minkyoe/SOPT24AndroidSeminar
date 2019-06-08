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
import com.example.sopt24_week3.Activity.WebtoonActivity
import com.example.sopt24_week3.Data.EpisodeOverviewData
import com.example.sopt24_week3.R
import org.jetbrains.anko.startActivity

class EpisodeOverviewRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<EpisodeOverviewData>):RecyclerView.Adapter<EpisodeOverviewRecyclerViewAdapter.Holder>() {
    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx)
            .load(dataList[position].img_url)
            .into(holder.img_thumbnail)

        holder.title.text = dataList[position].title
        holder.description.text = "조회수 "+
                dataList[position].num_view.toString()+" "+
                dataList[position].publish_date

        holder.container.setOnClickListener{
            ctx.startActivity<WebtoonActivity>(
                "title" to dataList[position].title,
                "idx" to dataList[position].product_id,
                "episode_id" to dataList[position].episode_id)
            }
        }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_episode_overview,viewGroup,false)
        return Holder(view)
    }


    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        var container = itemView.findViewById(R.id.ll_rv_item_episode_overview_container) as LinearLayout
        var img_thumbnail = itemView.findViewById(R.id.img_rv_item_episode_overview_thumbnail) as ImageView
        var title = itemView.findViewById(R.id.txt_rv_item_episode_overview_title) as TextView
        var description = itemView.findViewById(R.id.txt_rv_item_episode_overview_description) as TextView
    }
}
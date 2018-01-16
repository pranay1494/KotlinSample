package com.example.pranay.cryptocompare

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by kuliza-336 on 16/01/18.
 */

class Adapter(context:Context,name:String?) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    lateinit var context:Context
    var posts:String?

    init {
        this.context = context
        this.posts = name
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.tvPost.setText(posts)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.row_text,parent,false))

    }

    override fun getItemCount(): Int {
        return 10;
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tvPost:TextView = itemView!!.findViewById(R.id.tvPosts);
    }
}

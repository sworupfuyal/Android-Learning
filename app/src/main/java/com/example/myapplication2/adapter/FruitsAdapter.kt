package com.example.myapplication2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.R

class FruitsAdapter (
    val context: Context,
    val imageList: ArrayList<Int>,
    val titleList: ArrayList<String> ,
    val descList: ArrayList<String>,
):RecyclerView.Adapter<FruitsAdapter.FruitsViewHolder>()  {
    class FruitsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image :ImageView=itemView.findViewById(R.id.imageView2)
        val title :TextView=itemView.findViewById(R.id.textView4)
        val desc :TextView=itemView.findViewById(R.id.textView17)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        val itemView: View=LayoutInflater.from(context).inflate(R.layout.sample,parent,false)
        return FruitsViewHolder(itemView )

    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.title.text=titleList[position]
        holder.desc.text=descList[position]
        holder.image.setImageResource(imageList[position])
    }
}
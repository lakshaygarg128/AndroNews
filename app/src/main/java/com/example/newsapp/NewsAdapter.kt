package com.example.newsapp

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.zip.Inflater

class NewsAdapter (private val listner :itemclicked): RecyclerView.Adapter<NewsViewHolder>() {
    var items : ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.newsitem,parent,false)
        val viewholder = NewsViewHolder(view)
        view.setOnClickListener {
         listner.onitemclicked(items[viewholder.adapterPosition])
        }
        return viewholder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
      val currentitem  =items[position]
        holder.title.text= currentitem.title
        Glide.with(holder.itemView.context).load(currentitem.imageurl).into(holder.image)
        holder.author.text = currentitem.author
    }

    override fun getItemCount(): Int {
    val count =items.size
        return count
    }
    fun updatenews (updated : ArrayList<News>){
        items.clear()
        items.addAll(updated)
        notifyDataSetChanged()
    }


}
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
val title : TextView = itemView.findViewById(R.id.Title)
    val image :ImageView = itemView.findViewById(R.id.imageview)
    val author :TextView = itemView.findViewById(R.id.author)
}
interface itemclicked {
fun onitemclicked(item :News)
}
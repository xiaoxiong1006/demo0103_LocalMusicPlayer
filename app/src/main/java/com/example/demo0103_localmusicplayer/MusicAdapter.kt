package com.example.demo0103_localmusicplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jean.jcplayer.model.JcAudio
import kotlinx.android.synthetic.main.item_layout.view.*

class MusicAdapter(private val musicList: List<JcAudio>,
                   private  val itemClickListener: OnItemClickListener)
                                :RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    interface OnItemClickListener{
        fun onItemClick(item: JcAudio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MusicViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {

        val currentItem = musicList[position]

        holder.textView.text = currentItem.title

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(currentItem)
        }

    }

    override fun getItemCount()=musicList.size

    class MusicViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.textView
    }
}
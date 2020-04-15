package com.example.kecoa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kecoa.R
import kotlinx.android.synthetic.main.detail_item.view.*

class DetailAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val data = mutableListOf<Int>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        DetailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.detail_item, parent, false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as DetailViewHolder
        val currData = data[position]
        holder.binding(currData)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked()
        }
    }

    inner class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun binding(data: Int) {
            data.let {
                Glide.with(itemView.context).load(data).into(itemView.ivImage)
            }
        }
    }

    fun addData(data: List<Int>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    interface OnItemClickCallback {
        fun onItemClicked()
    }
}
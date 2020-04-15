package com.example.kecoa.adapter

import PageDecoration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.kecoa.R
import com.example.kecoa.model.KecoaModel
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = mutableListOf<KecoaModel>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        KecoaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as KecoaViewHolder
        val currData = data[position]
        holder.binding(currData)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(currData) }
    }

    inner class KecoaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun binding(kecoaModel: KecoaModel) {
            itemView.tvName.text = kecoaModel.name
            itemView.rvDetail.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            itemView.rvDetail.animation
            val detailAdapater = DetailAdapter()
            detailAdapater.addData(kecoaModel.image)
            itemView.rvDetail.addItemDecoration(PageDecoration())
            itemView.rvDetail.setOnFlingListener(null)
            PagerSnapHelper().attachToRecyclerView(itemView.rvDetail)
            itemView.rvDetail.adapter = detailAdapater
            detailAdapater.setOnItemClickCallback(object: DetailAdapter.OnItemClickCallback {
                override fun onItemClicked() {
                    onItemClickCallback.onItemClicked(kecoaModel)
                }
            })
        }
    }

    fun addData(data: List<KecoaModel>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: KecoaModel)
    }
}
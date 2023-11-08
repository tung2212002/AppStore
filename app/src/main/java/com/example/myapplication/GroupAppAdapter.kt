package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GroupAppAdapter(val items: ArrayList<GroupApp>): RecyclerView.Adapter<GroupAppAdapter.GroupAppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupAppViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_group_app, parent, false)

        return GroupAppViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GroupAppViewHolder, position: Int) {
        val groupApp = items[position]
        holder.bind(groupApp)
    }

    class GroupAppViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.txtTitleGroupApp)
        private val recyclerView: RecyclerView = itemView.findViewById(R.id.rlvGroupApp)

        fun bind(groupApp: GroupApp){
            title.text = groupApp.title
            recyclerView.apply {
                adapter = AppAdapter(groupApp.appList)
                layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL,false)
            }
        }
    }
}
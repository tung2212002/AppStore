package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AppAdapter(val items: ArrayList<App>): RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_app, parent, false)

        return AppViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = items[position]
        holder.bind(app)
    }

    class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.ivLogoApp)
        private val title: TextView = itemView.findViewById(R.id.txtTitleApp)
        private val rate: TextView = itemView.findViewById(R.id.txtRateApp)

        fun bind(app: App) {
            Glide
                .with(itemView.context)
                .load(app.logoPath)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(image)
            title.text = app.title
            rate.text = app.rate.toString()
        }
    }
}
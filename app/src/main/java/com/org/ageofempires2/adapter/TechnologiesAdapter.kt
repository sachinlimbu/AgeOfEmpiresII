package com.org.ageofempires2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.org.ageofempires2.R
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import kotlinx.android.synthetic.main.technologies_list_view.view.*

class TechnologiesAdapter(
    private val aoeMainBase: AoeMainBase
): RecyclerView.Adapter<TechnologiesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.technologies_list_view,parent,false))
    }
    override fun getItemCount(): Int {
        return aoeMainBase.technologies.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = aoeMainBase.technologies[position].name

    }
    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        var name: TextView = view.tech_name

    }
}
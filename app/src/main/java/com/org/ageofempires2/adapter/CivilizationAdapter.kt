package com.org.ageofempires2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.org.ageofempires2.R
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import kotlinx.android.synthetic.main.listofcivilization.view.*

class CivilizationAdapter(
    private val AoeMainBase: AoeMainBase
): RecyclerView.Adapter<CivilizationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.listofcivilization,parent,false))
    }
    override fun getItemCount(): Int {
        return AoeMainBase.civilizations.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = AoeMainBase.civilizations[position].id.toString()
        holder.text.text = AoeMainBase.civilizations[position].name
    }
    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        var id: TextView = view.typicode_id
        var text: TextView = view.typicode_title
    }
}
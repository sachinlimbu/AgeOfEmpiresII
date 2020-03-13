package com.org.ageofempires2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.org.ageofempires2.R
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import kotlinx.android.synthetic.main.structures_list_view.view.*

class StructuresAdapter (private val aoeMainBase: AoeMainBase
): RecyclerView.Adapter<StructuresAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.structures_list_view,parent,false))
    }
    override fun getItemCount(): Int {
        return aoeMainBase.structures.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = aoeMainBase.structures[position].name
        holder.expansion.text = aoeMainBase.structures[position].expansion
        holder.hitpoint.text = aoeMainBase.structures[position].hit_points.toString()
        holder.cost.text = aoeMainBase.structures[position].cost.toString()
        holder.age.text = aoeMainBase.structures[position].age

    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var name: TextView = view.structures_name_id
        var expansion = view.structures_expansion_id
        var hitpoint = view.structures_hitpoint_id
        var cost = view.structures_cost_id
        var age = view.structures_age_id


    }
}
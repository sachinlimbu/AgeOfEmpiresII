package com.org.ageofempires2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.org.ageofempires2.R
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import kotlinx.android.synthetic.main.civilizations_list_view.view.*

class CivilizationAdapter(
    private val aoeMainBase: AoeMainBase
): RecyclerView.Adapter<CivilizationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.civilizations_list_view,parent,false))
    }
    override fun getItemCount(): Int {
        return aoeMainBase.civilizations.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = aoeMainBase.civilizations[position].name
        holder.expansion.text = aoeMainBase.civilizations[position].expansion
        holder.armytype.text = aoeMainBase.civilizations[position].army_type
        holder.teamBonus.text = aoeMainBase.civilizations[position].team_bonus
        holder.civilBonus.text = aoeMainBase.civilizations[position].civilization_bonus.toString()
    }
    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        var name: TextView = view.civilization_name
        var expansion: TextView = view.civilization_expansion
        var armytype:TextView = view.civilization_army_type
        var teamBonus:TextView = view.civilization_team_bonus
        var civilBonus:TextView = view.civilization_civilization_bonus

    }
}
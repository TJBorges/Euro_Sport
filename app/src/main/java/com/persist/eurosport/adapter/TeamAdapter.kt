package com.persist.eurosport.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.persist.eurosport.R
import com.persist.eurosport.domain.Team
import kotlinx.android.synthetic.main.cell_team_item.view.*


class TeamAdapter (teams: List<Team>,
                   internal var ctx: Context,
                   private val callback: (Team) -> Unit): RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    internal var teamList: List<Team> = ArrayList<Team>()
    init { this.teamList = teams  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_team_item, parent, false)
        val viewHolder = ViewHolder(view)

        viewHolder.itemView.setOnClickListener {
            val team = teamList[viewHolder.adapterPosition]
            callback(team)
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val team = teamList[position]
        holder.itemView.txtTitle.text = team.name
        holder.itemView.imgFlag.setImageResource(team.flagId)
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var title = view.txtTitle
        val flagId = view.imgFlag
    }

}
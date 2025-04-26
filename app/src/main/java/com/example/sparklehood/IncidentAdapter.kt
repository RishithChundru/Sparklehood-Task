package com.example.sparklehood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IncidentAdapter(
    private var incidents: List<Incident>,
    private val onItemClick: (Incident) -> Unit
) : RecyclerView.Adapter<IncidentAdapter.IncidentViewHolder>() {

    inner class IncidentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.titleText)
        private val severity = view.findViewById<TextView>(R.id.severityText)
        private val date = view.findViewById<TextView>(R.id.dateText)

        fun bind(incident: Incident) {
            title.text = incident.title
            severity.text = "Severity: ${incident.severity}"
            date.text = "Reported: ${incident.reportedAt}"
            itemView.setOnClickListener { onItemClick(incident) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_incident, parent, false)
        return IncidentViewHolder(view)
    }

    override fun onBindViewHolder(holder: IncidentViewHolder, position: Int) {
        holder.bind(incidents[position])
    }

    override fun getItemCount(): Int = incidents.size

    fun updateList(newList: List<Incident>) {
        incidents = newList
        notifyDataSetChanged()
    }
}

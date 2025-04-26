package com.example.sparklehood

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: IncidentAdapter
    private val allIncidents = mutableListOf(
        Incident(1, "Biased Algorithm", "Algorithm consistently favored...", "Medium", "2025-03-15"),
        Incident(2, "Data Leak", "AI leaked sensitive data", "High", "2025-04-01")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val spinner = findViewById<Spinner>(R.id.severitySpinner)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        adapter = IncidentAdapter(allIncidents) { incident ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("incident", incident)
            startActivity(intent)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val severities = listOf("All", "High", "Medium", "Low")
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, severities)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p: AdapterView<*>, v: View?, position: Int, id: Long) {
                val selected = severities[position]
                val filtered = if (selected == "All") allIncidents else allIncidents.filter { it.severity == selected }
                adapter.updateList(filtered)
            }
            override fun onNothingSelected(p: AdapterView<*>?) {}
        }

        fab.setOnClickListener {
            startActivityForResult(Intent(this, ReportIncidentActivity::class.java), 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            val newIncident = data.getSerializableExtra("newIncident") as Incident
            allIncidents.add(newIncident)
            adapter.updateList(allIncidents)
        }
}
}
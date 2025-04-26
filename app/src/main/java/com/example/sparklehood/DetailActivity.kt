package com.example.sparklehood

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val incident = intent.getSerializableExtra("incident") as Incident

        findViewById<TextView>(R.id.titleDetail).text = incident.title
        findViewById<TextView>(R.id.severityDetail).text = "Severity: ${incident.severity}"
        findViewById<TextView>(R.id.dateDetail).text = "Reported: ${incident.reportedAt}"
        findViewById<TextView>(R.id.descriptionDetail).text = incident.description
    }
}

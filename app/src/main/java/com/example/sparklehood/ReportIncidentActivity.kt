package com.example.sparklehood

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.Random

class ReportIncidentActivity : AppCompatActivity() {
    private lateinit var titleInput: EditText
    private lateinit var descInput: EditText
    private lateinit var severitySpinner: Spinner
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_incident)
        titleInput = findViewById(R.id.titleInput)
        descInput = findViewById(R.id.descInput)
        severitySpinner = findViewById(R.id.severitySpinner)

        val saveBtn = findViewById<Button>(R.id.saveBtn)

        severitySpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("High", "Medium", "Low"))

        saveBtn.setOnClickListener {
            val title = titleInput.text.toString().trim()
            val desc = descInput.text.toString().trim()
            val severity = severitySpinner.selectedItem.toString()

            if (title.isEmpty() || desc.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val id = Random().nextInt(1000)
            val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            val incident = Incident(id, title, desc, severity, date)

            val result = Intent()
            result.putExtra("newIncident", incident)
            setResult(RESULT_OK, result)
            finish()

        }
    }
    }
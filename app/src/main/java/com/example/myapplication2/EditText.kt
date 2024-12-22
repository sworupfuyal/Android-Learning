package com.example.myapplication2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditTextActivity : AppCompatActivity() { // Renamed to avoid conflict
    lateinit var name: EditText
    lateinit var button: Button
    lateinit var display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_text)

        // Initializing views
        name = findViewById(R.id.editTextText)
        button = findViewById(R.id.button) // Ensure your button ID is correct
        display = findViewById(R.id.textView)

        // Set up button click listener
        button.setOnClickListener {
            val data: String = name.text.toString() // Access text content of EditText
            display.text = data
        }

        // Handle system window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

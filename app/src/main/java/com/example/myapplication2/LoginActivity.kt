package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countries = arrayOf("USA", "Canada", "India", "Nepal")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.countrySpinner.adapter = adapter

        binding.submitButton.setOnClickListener {
            val fullName = binding.fullNameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            val genderId = binding.genderRadioGroup.checkedRadioButtonId
            val genderRadioButton = findViewById<RadioButton>(genderId)
            val gender = genderRadioButton?.text.toString()

            val country = binding.countrySpinner.selectedItem.toString()
            val city = binding.autoCompleteTextView.text.toString()

            if (fullName.isEmpty()) {
                binding.fullNameEditText.error = "Full Name cannot be empty"
            } else if (email.isEmpty()) {
                binding.emailEditText.error = "Email cannot be empty"
            } else if (password.isEmpty()) {
                binding.passwordEditText.error = "Password cannot be empty"
            } else if (!binding.termsCheckBox.isChecked) {
                binding.errorMessage.visibility = TextView.VISIBLE
            } else {
                val intent = Intent(this@LoginActivity, DestinationActivity::class.java)
                intent.putExtra("fullName", fullName)
                intent.putExtra("email", email)
                intent.putExtra("gender", gender)
                intent.putExtra("country", country)
                intent.putExtra("city", city)
                startActivity(intent)
                finish()
            }
        }
    }
}

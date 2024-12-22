package com.example.myapplication2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication2.databinding.ActivityDestiantionBinding

class DestinationActivity : AppCompatActivity() {

    lateinit var binding: ActivityDestiantionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDestiantionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fullName = intent.getStringExtra("fullName") ?: "No Name Provided"
        val email = intent.getStringExtra("email") ?: "No Email Provided"
        val gender = intent.getStringExtra("gender") ?: "No Gender Provided"
        val country = intent.getStringExtra("country") ?: "No Country Provided"
        val city = intent.getStringExtra("city") ?: "No City Provided"

        binding.apply {
            welcomeTextView.text = "Welcome, $fullName"
            emailTextView.text = "Email: $email"
            genderTextView.text = "Gender: $gender"
            countryTextView.text = "Country: $country"
            cityTextView.text = "City: $city"
        }
    }
}

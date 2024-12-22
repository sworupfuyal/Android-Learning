package com.example.myapplication2

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class Task1Activity : AppCompatActivity() {

     lateinit var signupButton: Button
     lateinit var emailField: TextInputEditText
     lateinit var passwordField: TextInputEditText
     lateinit var lastNameField: TextInputEditText
     lateinit var firstNameField: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)


        signupButton = findViewById(R.id.button3)
        emailField = findViewById(R.id.emailtext)
        passwordField = findViewById(R.id.passwordtext)
        lastNameField = findViewById(R.id.lastnametext)
        firstNameField = findViewById(R.id.firstnametext)


        signupButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            val lastName = lastNameField.text.toString().trim()
            val firstName = firstNameField.text.toString().trim()


            if (email.isEmpty() || password.isEmpty() || lastName.isEmpty() || firstName.isEmpty()) {
                Toast.makeText(this, "Please fill in al", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(this, " Successful!", Toast.LENGTH_SHORT).show()


            }
        }
    }
}

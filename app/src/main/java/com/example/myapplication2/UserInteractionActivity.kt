package com.example.myapplication2

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class UserInteractionActivity : AppCompatActivity() {
    lateinit var buttonAlert :Button
    lateinit var buttonSnack :Button
    lateinit var buttonToast : Button
    lateinit var main : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_interaction)
        buttonAlert = findViewById(R.id.btnAlert)
        buttonSnack = findViewById(R.id.btnSnack)
        buttonToast = findViewById(R.id.btnToast)
        main = findViewById(R.id.main)
        buttonToast.setOnClickListener {
            Toast.makeText(
                this@UserInteractionActivity,
                "Invalid Login Detail",
                Toast.LENGTH_LONG
            ).show()
        }

        buttonSnack.setOnClickListener {
            Snackbar.make(main,
                "no Internet",
                Snackbar.LENGTH_LONG).setAction("Retry",{

            }).show()
        }
        buttonAlert.setOnClickListener {
            val alert =AlertDialog.Builder(
            this@UserInteractionActivity,
                )
            alert.setTitle("Confirm")
                .setMessage("Are you sure")
                .setIcon(R.drawable.img_3)
                .setPositiveButton("yes", DialogInterface.OnClickListener{
                    dialogInterface, i ->
                })
                .setNegativeButton("No",DialogInterface.OnClickListener{
                        dialogInterface, i ->
                    dialogInterface.dismiss()
                })
            alert.create().show()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
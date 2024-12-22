package com.example.myapplication2

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioActivity : AppCompatActivity() {
    lateinit var tiger: RadioButton
    lateinit var lion: RadioButton
    lateinit var panther: RadioButton
    lateinit var image: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio)
        tiger =findViewById(R.id.radioTiger)
        lion =findViewById(R.id.radioLion)
        panther =findViewById(R.id.radioPanther)
        image =findViewById(R.id.imageView)
        tiger.setOnClickListener{
            image.setImageResource(R.drawable.img_1)

        }
        lion.setOnClickListener{
            image.setImageResource(R.drawable.img_2)

        }
        panther.setOnClickListener{
            image.setImageResource(R.drawable.img_3)

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
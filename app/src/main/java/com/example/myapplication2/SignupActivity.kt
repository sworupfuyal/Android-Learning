package com.example.myapplication2

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignupActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    lateinit var  spinner: Spinner
    lateinit var  textView: TextView
    lateinit var   date: EditText
    lateinit var  autoCompleteTextView: AutoCompleteTextView
    var countries = arrayOf(
        "Nepal","China","India" ,"America","Japan","India","Pakistan",
        "Canada","Australia","Sweden"
    )

    var cities = arrayOf("Kathmandu", "Bhaktapur", "Lalitpur","Aalapot",
        "Fulera","Mirzapur","Gokuldham", "Mahismate")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        spinner = findViewById(R.id.spinner1)
        textView = findViewById(R.id.displaySpinner)
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        date = findViewById(R.id.editTextDate)
        date.isClickable=true
        date.isFocusable=false
        date.setOnClickListener { loadCalendar() }



        val autoadapter = ArrayAdapter(
            this@SignupActivity,
            android.R.layout.simple_list_item_1,
            cities

        )
        autoCompleteTextView.setAdapter(autoadapter)
        autoCompleteTextView.threshold=2


        val adapter = ArrayAdapter(
            this@SignupActivity,
            android.R.layout.simple_list_item_1,
            countries

        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_dropdown_item_1line
        )

        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.city)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun loadCalendar(){
        val c =Calendar.getInstance()
        val year =c.get(Calendar.YEAR)
        val month =c.get(Calendar.MONTH)
        val day =c.get(Calendar.DAY_OF_MONTH)

        val dialog= DatePickerDialog(
            this@SignupActivity,
            DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                date.setText("$year/${month+1}/$day")
            },year,month,day


        )
    dialog.show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        if(parent !=null){
            textView.text =
                parent.getItemAtPosition(position).toString()


        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}
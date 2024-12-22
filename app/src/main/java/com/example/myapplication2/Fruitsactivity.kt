package com.example.myapplication2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.adapter.FruitsAdapter

class Fruitsactivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var imageList=ArrayList<Int>()
    var titleList=ArrayList<String>()
    var descList=ArrayList<String>()
    lateinit var FruitsAdapter: FruitsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fruitsactivity)
        recyclerView=findViewById(R.id.recycler)
        imageList.add(R.drawable.img)
        imageList.add(R.drawable.img_2)
        imageList.add(R.drawable.img_3)

        titleList.add("AI Scene")
        titleList.add("LION")
        titleList.add("PANTHER")


        descList.add("This is AI generated scene")
        descList.add("this is Lion")
        descList.add("This is Panther")
        FruitsAdapter= FruitsAdapter(
            this@Fruitsactivity,imageList,titleList,descList
        )
        recyclerView.adapter= FruitsAdapter
     //   recyclerView.layoutManager= LinearLayoutManager(this@Fruitsactivity, LinearLayoutManager.HORIZONTAL,false)
        //Grid
        recyclerView.layoutManager=GridLayoutManager(this@Fruitsactivity,2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
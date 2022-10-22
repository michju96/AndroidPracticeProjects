package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource
import com.example.affirmations.databinding.ListItemBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ListItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataSet = Datasource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(baseContext,3)
        recyclerView.adapter = ItemAdapter(this,myDataSet)
        recyclerView.setHasFixedSize(true)
//        val textView: TextView = findViewById(R.id.textview)
//        textView.text = Datasource().loadAffirmations().size.toString()
    }
}
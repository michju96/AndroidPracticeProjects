package com.raywenderlich.testrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.raywenderlich.testrecycleview.databinding.ActivityMainBinding
import com.raywenderlich.testrecycleview.ui.main.MainFragment
import com.raywenderlich.testrecycleview.ui.main.PapiezAdapter
import com.raywenderlich.testrecycleview.ui.main.PapiezModel
import okhttp3.internal.notify

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

    }

}

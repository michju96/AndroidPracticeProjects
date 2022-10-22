package com.raywenderlich.listmenker.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raywenderlich.listmenker.MainActivity
import com.raywenderlich.listmenker.R
import com.raywenderlich.listmenker.TaskList
import com.raywenderlich.listmenker.ui.detail.ui.detail.ListDetailFragment

class ListDetailActivity : AppCompatActivity() {

    lateinit var list: TaskList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_detail_activity)
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY)!!
        title = list.name
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListDetailFragment.newInstance())
                .commitNow()
        }
    }
}
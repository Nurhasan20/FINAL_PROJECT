package com.example.praktikum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*

class listActivity : AppCompatActivity() {

    val list = ArrayList<menu> ()
    val ListUsers = arrayOf (menu(name = "Alpha"),"Bravo",
        "Charlie",
        "Delta",
        "Echo",
        "Foxtror",
        "Golf",
        "Hotel",
        "India",
        "Juliet"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        for (i in 0 until ListUsers.size){
            list.add(menu(ListUsers.get(i) as String))
            if (ListUsers.size-1==i){
                val Adapter = adapter(list)
                Adapter.notifyDataSetChanged()
                mRecyclerView.adapter = Adapter
            }
        }
    }
}

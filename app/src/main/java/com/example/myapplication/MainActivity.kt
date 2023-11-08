package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val arrayList: ArrayList<GroupApp> = arrayListOf()

        repeat(10) {
            val arrayAppList: ArrayList<App> = arrayListOf()
            repeat(10) {
                arrayAppList.add(
                    App(
                        logoPath = "https://pbs.twimg.com/profile_images/1684669052839473152/e_ATYqfK_400x400.jpg",
                        title = "GooglePlay",
                        rate = 4.0
                    )
                )
            }
            arrayList.add(GroupApp(title = "Popular apps", appList = arrayAppList))
        }

        findViewById<RecyclerView>(R.id.rvlMain).apply {
            adapter = GroupAppAdapter(arrayList)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }
}
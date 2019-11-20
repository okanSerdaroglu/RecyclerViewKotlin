package com.okanserdaroglu.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var allViews = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareData()

        val adapter = ViewAdapter(allViews)
        recyclerViewAllViews.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu,menu)

        return super.onCreateOptionsMenu(menu)

    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        var id  = item?.itemId



        when (id) {
            R.id.horizontal -> {
                var linearLayoutManager = LinearLayoutManager (this,LinearLayoutManager.HORIZONTAL,false)
                recyclerViewAllViews.layoutManager = linearLayoutManager
            }

            R.id.grid -> {
                var gridLayoutManager = GridLayoutManager (this,2)
                recyclerViewAllViews.layoutManager = gridLayoutManager
            }

            R.id.vertical -> {
                var linearLayoutManager = LinearLayoutManager (this,LinearLayoutManager.VERTICAL,false)
                recyclerViewAllViews.layoutManager = linearLayoutManager
            }

        }

        return super.onOptionsItemSelected(item)
    }

    private fun prepareData () : ArrayList<View> {

        val images = arrayOf(R.drawable.thumb_1_0, R.drawable.thumb_1_1, R.drawable.thumb_1_2, R.drawable.thumb_1_3,
            R.drawable.thumb_1_4, R.drawable.thumb_1_5, R.drawable.thumb_1_6, R.drawable.thumb_1_7,
            R.drawable.thumb_1_8, R.drawable.thumb_1_9,

            R.drawable.thumb_2_0, R.drawable.thumb_2_1, R.drawable.thumb_2_2, R.drawable.thumb_2_3,
            R.drawable.thumb_2_4, R.drawable.thumb_2_5, R.drawable.thumb_2_6, R.drawable.thumb_2_7,
            R.drawable.thumb_2_8, R.drawable.thumb_2_9,

            R.drawable.thumb_3_0, R.drawable.thumb_3_1, R.drawable.thumb_3_2, R.drawable.thumb_3_3,
            R.drawable.thumb_3_4, R.drawable.thumb_3_5, R.drawable.thumb_3_6, R.drawable.thumb_3_7,
            R.drawable.thumb_3_8, R.drawable.thumb_3_9,

            R.drawable.thumb_4_0, R.drawable.thumb_4_1, R.drawable.thumb_4_2, R.drawable.thumb_4_3,
            R.drawable.thumb_4_4, R.drawable.thumb_4_5, R.drawable.thumb_4_6, R.drawable.thumb_4_7,
            R.drawable.thumb_4_8, R.drawable.thumb_4_9,

            R.drawable.thumb_5_0, R.drawable.thumb_5_1, R.drawable.thumb_5_2, R.drawable.thumb_5_3,
            R.drawable.thumb_5_4, R.drawable.thumb_5_5, R.drawable.thumb_5_6, R.drawable.thumb_5_7,
            R.drawable.thumb_5_8, R.drawable.thumb_5_9,

            R.drawable.thumb_6_0, R.drawable.thumb_6_1, R.drawable.thumb_6_2, R.drawable.thumb_6_3,
            R.drawable.thumb_6_4, R.drawable.thumb_6_5, R.drawable.thumb_6_6, R.drawable.thumb_6_7,
            R.drawable.thumb_6_8, R.drawable.thumb_6_9,

            R.drawable.thumb_7_0, R.drawable.thumb_7_1, R.drawable.thumb_7_2, R.drawable.thumb_7_3,
            R.drawable.thumb_7_4)


        for (i in images.indices) {

            val image = View("View + $i", "Detail $i", images[i])
            allViews.add(image)

        }

        return allViews

    }

}

package com.vi.demoapp

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>
    lateinit var cv_click:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPagerMain)
        cv_click = findViewById(R.id.cv_click)

//        val slide_up:Animation = AnimationUtils.loadAnimation(this,R.anim.slide_up)
        // on below line we are initializing
        // our image list and adding data to it.
        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.oil_natural_sector
        imageList = imageList + R.drawable.project_management

        // on below line we are initializing our view
        // pager adapter and adding image list to it.
        viewPagerAdapter = ViewPagerAdapter(this@MainActivity, imageList)

        // on below line we are setting
        // adapter to our view pager.
        viewPager.adapter = viewPagerAdapter

        cv_click.setOnClickListener {
            val current = viewPager.currentItem + 1
            if (current < viewPager.childCount) {
                viewPager.currentItem = current

            } else {
                viewPager.currentItem = 0

            }
        }


    }
}
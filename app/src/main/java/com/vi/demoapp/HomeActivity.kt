package com.vi.demoapp

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.vi.demoapp.fragment.FirstFragment
import com.vi.demoapp.fragment.HomeFragment
import com.vi.demoapp.fragment.SecondFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var cv_click:CardView
    var isClick =false
    var progressBar1:View?=null
    var progressBar2:View?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        cv_click = findViewById(R.id.cv_click)
        progressBar1 = findViewById(R.id.progressBar1)
        progressBar2 = findViewById(R.id.progressBar2)
        progressBar1!!.visibility = View.GONE
        progressBar2!!.visibility = View.GONE

        val fragment2: Fragment = HomeFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_one, fragment2)
        fragmentTransaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_up)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()


            cv_click.setOnClickListener {
                if (isClick==false){
                    val fragment2: Fragment = FirstFragment()
                    val fragmentManager: FragmentManager = supportFragmentManager
                    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_up)
                    fragmentTransaction.replace(R.id.fragment_one, fragment2)
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                    isClick =true
                    progressBar1!!.visibility = View.VISIBLE
                    progressBar2!!.visibility = View.GONE
                }else{
                    val fragment2: Fragment = SecondFragment()
                    val fragmentManager: FragmentManager = supportFragmentManager
                    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_up)
                    fragmentTransaction.replace(R.id.fragment_one, fragment2)
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                    isClick =false
                    progressBar1!!.visibility = View.GONE
                    progressBar2!!.visibility = View.VISIBLE
                }
            }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
package com.vi.demoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.viewpager.widget.PagerAdapter
import java.util.*


class ViewPagerAdapter(val context: Context, val imageList: List<Int>) : PagerAdapter(),Animation.AnimationListener  {

    override fun getCount(): Int {
        return imageList.size
    }

    // on below line we are returning the object
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }

    // on below line we are initializing
    // our item and inflating our layout file
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // on below line we are initializing
        // our layout inflater.
        val mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // on below line we are inflating our custom
        // layout file which we have created.
        val itemView: View = mLayoutInflater.inflate(R.layout.item, container, false)

        // on below line we are initializing
        // our image view with the id.
        val imageView: ImageView = itemView.findViewById(R.id.imageViewMain) as ImageView

        // on below line we are setting
        // image resource for image view.
        imageView.setImageResource(imageList.get(position))

        // on the below line we are adding this
        // item view to the container.
        Objects.requireNonNull(container).addView(itemView)

        // on below line we are simply
        // returning our item view.
        return itemView
    }

    override fun onAnimationStart(animation: Animation?) {
      AnimationUtils.loadAnimation(context,R.anim.slide_up)
    }

    override fun onAnimationEnd(animation: Animation?) {
        AnimationUtils.loadAnimation(context,R.anim.slide_up)
    }


    override fun onAnimationRepeat(animation: Animation?) {
        AnimationUtils.loadAnimation(context,R.anim.slide_up)
    }

    // on below line we are creating a destroy item method.
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // on below line we are removing view
        container.removeView(`object` as RelativeLayout)
    }
}
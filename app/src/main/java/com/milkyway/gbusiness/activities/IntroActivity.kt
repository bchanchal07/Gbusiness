@file:Suppress("DEPRECATION")
package com.milkyway.gbusiness.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import kotlinx.android.synthetic.main.activity_intro.*


class IntroActivity : AppCompatActivity(){
    private var myViewPagerAdapter: MyViewPagerAdapter? = null
    private var dotsLayout: LinearLayout? = null
    private var layouts: IntArray? = null


  //  private var prefManager: PrefManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        //Set the layout


            setContentView(R.layout.activity_intro)



        dotsLayout = findViewById<LinearLayout>(R.id.layoutDots)
        // layouts of all intro sliders
        layouts = intArrayOf(R.layout.slide1, R.layout.slide2, R.layout.slide3)

        // adding bottom dots
        addBottomDots(0)

        // making notification bar transparent
        changeStatusBarColor()

        myViewPagerAdapter = MyViewPagerAdapter()
        view_pagers!!.adapter = myViewPagerAdapter
        view_pagers!!.addOnPageChangeListener(viewPagerPageChangeListener)

        btn_skip!!.setOnClickListener { launchHomeScreen() }

        btn_next!!.setOnClickListener(View.OnClickListener {
            // checking for last page & if last page home screen will be launched
            val current = getItem(+1)
            if (current < layouts!!.size) {
                // move to next screen
                view_pagers!!.currentItem = current
            } else {
              launchHomeScreen()
            }
        })
    }

    private fun launchHomeScreen() {
        CommonUtil.saveStringPreferences(this@IntroActivity, AppConstants.isFirstTime,"true")
        startActivity(Intent(this@IntroActivity, LoginActivity::class.java))
        finish()
    }


    private fun addBottomDots(currentPage: Int) {
        var dots: Array<TextView?> = arrayOfNulls(layouts!!.size)

        dotsLayout!!.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#8226;")
            dots[i]!!.textSize = 35f
          //  dots[i]!!.setTextColor(resources.getIntArray(R.array.array_dot_inactive)[currentPage])
            dotsLayout!!.addView(dots[i])
        }

        if (dots.isNotEmpty())
            dots[currentPage]!!.setTextColor(resources.getColor(android.R.color.holo_purple))
    }

    private fun getItem(i: Int): Int {
        return view_pagers!!.currentItem + i
    }



    //	viewpager change listener
    private var viewPagerPageChangeListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageSelected(position: Int) {
            addBottomDots(position)
            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts!!.size - 1) {
                // last page. make button text to GOT IT
                btn_next!!.text = getString(R.string.start)
                btn_skip!!.visibility = View.GONE
            } else {
                // still pages are left
                btn_next!!.text = getString(R.string.next)
                btn_skip!!.visibility = View.VISIBLE
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {
        }

        override fun onPageScrollStateChanged(arg0: Int) {
        }
    }


    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }


    
    inner class MyViewPagerAdapter : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = layoutInflater!!.inflate(layouts!![position], container, false)
            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return layouts!!.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }
    }


}
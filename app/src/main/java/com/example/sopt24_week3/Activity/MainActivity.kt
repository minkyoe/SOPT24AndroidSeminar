package com.example.sopt24_week3.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.example.sopt24_week3.DB.SharedPreferenceController
import com.example.sopt24_week3.Adapter.ProductMainPagerAdapter
import com.example.sopt24_week3.Adapter.SliderMainPagerAdapter
import com.example.sopt24_week3.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureTitleBar()
        configureMainTab()
        img_toolbar_main_action.setOnClickListener{
            if(SharedPreferenceController.getUserToken(this).isEmpty()){
                /*
                // without Anko
                val intent: Intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                */

                // with Anko
                startActivity<LoginActivity>()
            }
            else{
                SharedPreferenceController.clearUserToken(this)
                configureTitleBar()
            }
        }
    }
    override fun onResume() {
        super.onResume()
        configureTitleBar()
    }
    private fun configureTitleBar(){
        if(SharedPreferenceController.getUserToken(this).isEmpty()){
            img_toolbar_main_action.isSelected = false
        }
        else{
            img_toolbar_main_action.isSelected= true
        }
    }

    private fun configureMainTab() {

        // *********
        vp_main_product.adapter = ProductMainPagerAdapter(supportFragmentManager, 3)
        vp_main_product.offscreenPageLimit = 2
        tl_main_category.setupWithViewPager(vp_main_product)

        val navCategoryMainLayout: View = (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.navigation_category_main, null, false)
        tl_main_category.getTabAt(0)!!.customView = navCategoryMainLayout.
            findViewById(R.id.rl_nav_category_main_all) as RelativeLayout
        tl_main_category.getTabAt(1)!!.customView = navCategoryMainLayout.
            findViewById(R.id.rl_nav_category_main_new) as RelativeLayout
        tl_main_category.getTabAt(2)!!.customView = navCategoryMainLayout.
            findViewById(R.id.rl_nav_category_main_end) as RelativeLayout

        // **********
        vp_main_slider.adapter = SliderMainPagerAdapter(supportFragmentManager, 3)
        vp_main_slider.offscreenPageLimit = 2
        tl_main_indicator.setupWithViewPager(vp_main_slider)


    }
}














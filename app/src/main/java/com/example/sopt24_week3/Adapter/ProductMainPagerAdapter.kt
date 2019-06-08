package com.example.sopt24_week3.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.sopt24_week3.Fragment.AllProductMainFragment
import com.example.sopt24_week3.Fragment.EndProductMainFragment
import com.example.sopt24_week3.Fragment.NewProductMainFragment

class ProductMainPagerAdapter(fm: FragmentManager, private val num_fragment: Int): FragmentStatePagerAdapter(fm){
    companion object {
        private var allProductMainFragment: AllProductMainFragment? = null
        private var endProductMainFragment: EndProductMainFragment? = null
        private var newProductMainFragment: NewProductMainFragment? = null

        @Synchronized
        fun getAllProductMainFragment(): AllProductMainFragment{
            if(allProductMainFragment == null) allProductMainFragment = AllProductMainFragment()
            return allProductMainFragment!!
        }
        @Synchronized
        fun getEndProductMainFragment(): EndProductMainFragment{
            if(endProductMainFragment == null) endProductMainFragment = EndProductMainFragment()
            return endProductMainFragment!!
        }
        @Synchronized
        fun getNewProductMainFragment(): NewProductMainFragment{
            if(newProductMainFragment == null) newProductMainFragment = NewProductMainFragment()
            return newProductMainFragment!!
        }
    }

    override fun getItem(p0: Int): Fragment? {
        return when(p0){
            0 -> getAllProductMainFragment()
            1 -> getNewProductMainFragment()
            2 -> getEndProductMainFragment()
            else -> null
        }
    }

    override fun getCount(): Int{
        return num_fragment
    }
}


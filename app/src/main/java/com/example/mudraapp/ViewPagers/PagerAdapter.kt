package com.example.mudraapp.ViewPagers

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class PagerAdapter(val fragment: ArrayList<Fragment>, val fragmentManager: FragmentManager?) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(p0: Int): Fragment {
        return fragment[p0]

    }

    override fun getCount(): Int {
      return fragment.size
    }


}

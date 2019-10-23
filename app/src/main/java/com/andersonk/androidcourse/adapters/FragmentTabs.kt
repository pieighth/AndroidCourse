package com.andersonk.androidcourse.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.andersonk.androidcourse.fragments.HelloFragment
import com.andersonk.androidcourse.fragments.StackFragment

class FragmentTabs(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    val stackFragment = StackFragment()
    val helloFragment = HelloFragment()

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "stackFragment"
            else -> "helloFragment"
        }
    }
    override fun getItem(position: Int): Fragment {
        return when (position){
             0 -> stackFragment
            else -> helloFragment
        }
    }

    override fun getCount(): Int {
        return 2
    }

}
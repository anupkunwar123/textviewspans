package com.anupkunwar.textviewplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragments =
            listOf(Simple(), TypeWriter(), Pattern(), ColorGradient(), ColorGradientAnimating())
        val adapter = Adapter(fragments, supportFragmentManager)
        pager.adapter = adapter


    }

    class Adapter(
        private val fragmentList: List<Fragment>,
        supportFragmentManager: FragmentManager
    ) : FragmentStatePagerAdapter(
        supportFragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

    }
}

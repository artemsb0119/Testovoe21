package com.example.testovoe21

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MenuActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var cons1: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        cons1 = findViewById(R.id.cons1)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        val tab1: TabLayout.Tab = tabLayout.newTab()
        tab1.text = "Fuel consumption"
        tabLayout.addTab(tab1)

        val tab2: TabLayout.Tab = tabLayout.newTab()
        tab2.text = "The cost of travel"
        tabLayout.addTab(tab2)

        val tab3: TabLayout.Tab = tabLayout.newTab()
        tab3.text = "Modeling range"
        tabLayout.addTab(tab3)

        val tab4: TabLayout.Tab = tabLayout.newTab()
        tab4.text = "Settings"
        tabLayout.addTab(tab4)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(PotreblenieFragment(), "")
        adapter.addFragment(CostFragment(), "")
        adapter.addFragment(DiapazonFragment(), "")
        adapter.addFragment(SettingsFragment(), "")

        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}
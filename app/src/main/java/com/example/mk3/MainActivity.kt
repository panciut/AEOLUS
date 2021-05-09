package com.example.mk3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.children
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.mk3.calendar.Fragment_calendar
import com.example.mk3.ticket.Fragment_ticket
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {




   private val sharedViewModel:SharedViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fragment
        sharedViewModel.fragment_home = Fragment_home();
        sharedViewModel.fragment_ticket = Fragment_ticket();
        sharedViewModel.fragment_calendar = Fragment_calendar();
        sharedViewModel.fragment_equipment = Fragment_equipment();
        sharedViewModel.fragment_help = Fragment_help();
        sharedViewModel.fragment_segnaposto = Fragment_segnaposto();
        sharedViewModel.fragment_forecast = Fragment_forecast();


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_fl, sharedViewModel.fragment_home)
            commit()
        }

        //navigation bar
        na_view.bringToFront()
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        na_view.setNavigationItemSelectedListener(this)
        na_view.setCheckedItem(R.id.nav_home)


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                changeFragment(sharedViewModel.fragment_home)
            }
            R.id.nav_calendar -> {
                changeFragment(sharedViewModel.fragment_calendar)
            }
            R.id.nav_ticket -> {
                changeFragment(sharedViewModel.fragment_ticket)
            }
            R.id.nav_equipment -> {
                changeFragment(sharedViewModel.fragment_equipment)
            }
            R.id.nav_forecast -> {
                changeFragment(sharedViewModel.fragment_forecast)
            }
            R.id.nav_help -> {
                changeFragment(sharedViewModel.fragment_help)
            }
            R.id.nav_segnaposto -> {
                changeFragment(sharedViewModel.fragment_segnaposto)
            }

        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_fl, fragment)
            addToBackStack(null)
            commit()
        }
    }
}
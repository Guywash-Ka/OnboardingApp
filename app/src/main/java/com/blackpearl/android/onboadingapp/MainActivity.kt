package com.blackpearl.android.onboadingapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val headerView = navigationView.getHeaderView(0)
        val profileNameView = headerView.findViewById<TextView>(R.id.name_profile)
        val profileImageView = headerView.findViewById<ImageView>(R.id.image_profile)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

        profileNameView.setOnClickListener {
            loadFragment(ProfileFragment())
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        profileImageView.setOnClickListener {
            loadFragment(ProfileFragment())
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        onBottomNavigationItemSelected(bottomNavigationView)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> loadFragment(HomeFragment())
            R.id.nav_profile -> loadFragment(ProfileFragment())
            R.id.nav_challenges -> loadFragment(ChallengeFragment())
            R.id.nav_calendar -> loadFragment(CalendarFragment())
            R.id.nav_logout -> loadFragment(RegisterFragment())
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun onBottomNavigationItemSelected(bottomNavigationView: BottomNavigationView) {
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_profile -> loadFragment(ProfileFragment())
                R.id.nav_challenges -> loadFragment(ChallengeFragment())
                R.id.nav_calendar -> loadFragment(CalendarFragment())
            }
            true
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
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
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.blackpearl.android.onboadingapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        val navigationView = findViewById<NavigationView>(R.id.nav_view)
//        val headerView = navigationView.getHeaderView(0)
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.name_profile -> findNavController(R.id.nav_host_fragment).navigate(R.id.profile_fragment)
                R.id.image_profile -> findNavController(R.id.nav_host_fragment).navigate(R.id.profile_fragment)
                R.id.home_fragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.home_fragment)
                R.id.profile_fragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.profile_fragment)
                R.id.challenge_fragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.challenge_fragment)
                R.id.calendar_fragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.calendar_fragment)
            }
            false
        }
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home), drawerLayout)
//        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        binding.bottomNavigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener)

//        setSupportActionBar(toolbar)
//        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
//        navigationView.setNavigationItemSelectedListener(this)

//        onBottomNavigationItemSelected(bottomNavigationView)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.nav_home -> loadFragment(HomeFragment())
//            R.id.nav_profile -> loadFragment(ProfileFragment())
//            R.id.nav_challenges -> loadFragment(ChallengeFragment())
//            R.id.nav_calendar -> loadFragment(CalendarFragment())
//            R.id.nav_logout -> loadFragment(RegisterFragment())
//        }
//        drawerLayout.closeDrawer(GravityCompat.START)
//        return true
//    }

//    private fun onBottomNavigationItemSelected(bottomNavigationView: BottomNavigationView) {
//        bottomNavigationView.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.nav_home -> loadFragment(HomeFragment())
//                R.id.nav_profile -> loadFragment(ProfileFragment())
//                R.id.nav_challenges -> loadFragment(ChallengeFragment())
//                R.id.nav_calendar -> loadFragment(CalendarFragment())
//            }
//            true
//        }
//    }

//    private  fun loadFragment(fragment: Fragment){
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.fragment_container, fragment)
//        transaction.commit()
//    }

//    override fun onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START)
//        } else {
//            onBackPressedDispatcher.onBackPressed()
//        }
//    }
}
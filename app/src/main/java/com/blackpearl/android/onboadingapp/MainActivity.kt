package com.blackpearl.android.onboadingapp

import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.blackpearl.android.onboadingapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        binding.bottomNavigation.setupWithNavController(navController)

//        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.name_profile -> findNavController(R.id.nav_host_fragment).navigate(R.id.profile_fragment)
//                R.id.image_profile -> findNavController(R.id.nav_host_fragment).navigate(R.id.profile_fragment)
//                R.id.home_fragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.home_fragment)
//                R.id.profile_fragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.profile_fragment)
//                R.id.challenge_fragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.challenge_fragment)
//                R.id.calendar_fragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.calendar_fragment)
//            }
//            false
//        }

//        binding.bottomNavigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener)



    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }


}
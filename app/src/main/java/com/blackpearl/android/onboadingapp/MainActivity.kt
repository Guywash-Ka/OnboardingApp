package com.blackpearl.android.onboadingapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.blackpearl.android.onboadingapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var dataStoreManager: DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataStoreManager = DataStoreManager(application)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        checkIsLaunch()
//        getPoints()

        val topLevelDestinations = setOf(
            R.id.home_fragment, R.id.profile_fragment,
            R.id.quest_fragment, R.id.calendar_fragment,
            R.id.challenge_fragment, R.id.register_fragment,
            R.id.knowledge_fragment
        )


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(topLevelDestinations, binding.drawerLayout)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        binding.bottomNavigation.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun checkIsLaunch() {
        binding.apply {
            mainViewModel.getIsLaunched.observe(this@MainActivity){ isLaunched ->
                if (!isLaunched) {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.register_fragment)
                }
            }
        }
    }

    private fun getPoints() {
        binding.apply {
            mainViewModel.getPoints.observe(this@MainActivity){ points ->
                Log.d("POINTS_TAG", "$points")
            }
        }
    }


}
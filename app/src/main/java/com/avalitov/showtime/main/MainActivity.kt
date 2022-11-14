package com.avalitov.showtime.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.avalitov.showtime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Getting the NavHostFragment and NavController to use it further for app navigation
        navHostFragment = binding.navHost.getFragment()
        navController = navHostFragment.navController

        // Tying the NavController with Bottom Navigation Menu
        binding.bottomNav.setupWithNavController(navController)
    }
}
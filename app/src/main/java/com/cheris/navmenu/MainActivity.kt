package com.cheris.navmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDelegate
import com.cheris.navmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setUpTabBar()

    }

    private fun setUpTabBar() {

        binding.bottomNavBar.setOnItemSelectedListener {
            when(it) {
                R.id.nav_near -> binding.textMain.text = "Nearby"
                R.id.nav_new_chat -> binding.textMain.text = "Chat"
                R.id.nav_profile -> {
                    binding.textMain.text = "Profile"
                    binding.bottomNavBar.showBadge(R.id.nav_settings)
                }
                R.id.nav_settings -> {
                    binding.textMain.text = "Settings"
                    binding.bottomNavBar.dismissBadge(R.id.nav_settings)
                }
            }
        }
    }
}
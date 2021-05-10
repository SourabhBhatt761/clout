package com.srb.clout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.srb.clout.databinding.ActivityMainBinding
import com.srb.clout.view.stories.StoriesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityMainBinding
    private val binding get() = _binding
    private val storiesViewModel by viewModels<StoriesViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        binding.storiesRv.adapter =

        setUpNav()

        storiesViewModel.fetchTags()

        }

    override fun onResume() {
        super.onResume()
        storiesViewModel.tags.observe(this){


        }
    }


    private fun setUpNav() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.apply {
            setupWithNavController(navController)
            itemIconTintList = null
        }
    }

}


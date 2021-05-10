package com.srb.clout.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import coil.Coil
import coil.request.ImageRequest
import com.srb.clout.R
import com.srb.clout.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityMainBinding
    private val binding get() = _binding
    private val storiesViewModel by viewModels<HomeViewModel>()
    private val storiesAdapter = StoriesRecyclerAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        binding.storiesRv.adapter = storiesAdapter
        storiesViewModel.fetchTags()

        setUpNav()


        }

    override fun onResume() {
        super.onResume()
        storiesViewModel.tags.observe(this){
            it.forEach { tag ->
                val request = ImageRequest.Builder(this)
                    .data("https://i.imgur.com/${tag.backgroundHash}.jpg")
                    .size(resources.getDimensionPixelSize(R.dimen.story_head_image_size))
                    .build()
                Coil.imageLoader(this).enqueue(request)
            }
            storiesAdapter.submitList(it)

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


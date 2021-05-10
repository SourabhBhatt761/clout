package com.srb.clout.view.feed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import coil.Coil
import coil.request.ImageRequest
import com.srb.clout.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    private lateinit var _binding : FragmentFeedBinding
    private val binding  get() = _binding
    private val viewModel: FeedViewModel by viewModels()
    private val feedAdapter = FeedRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed") // TODO: turn into enum
        feed?.let { viewModel.updateFeed(it) }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(inflater,container,false)

        binding.feedRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = feedAdapter
        }
        viewModel.feed.observe(viewLifecycleOwner,{
            it.forEach { image ->
                val request = ImageRequest.Builder(requireContext())
                    .data("https://i.imgur.com/${image.cover}.jpg")
                    // Optional, but setting a ViewSizeResolver will conserve memory by limiting the size the image should be preloaded into memory at.
                    .size(binding.feedRv.width)
                    .build()
                Coil.imageLoader(requireContext()).enqueue(request)
            }
            feedAdapter.submitList(it)

        })
//        viewModel.updateFeed("hot")

        return _binding.root
    }


}
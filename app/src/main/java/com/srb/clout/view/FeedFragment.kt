package com.srb.clout.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.srb.clout.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    private lateinit var _binding : FragmentFeedBinding
    val binding  get() = _binding
    private lateinit var viewModel: FeedViewModel
    private val feedAdapter = FeedRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(inflater,container,false)

        arguments?.getString("feed").apply {
            this?.let { viewModel.updateFeed(it) }
        }

        binding.feedRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = feedAdapter
        }
        viewModel.feed.observe(viewLifecycleOwner,{
            feedAdapter.submitList(it)
        })
//        viewModel.updateFeed("hot")

        return _binding.root
    }


}
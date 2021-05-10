package com.srb.clout.view.feed

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.srb.clout.R
import com.srb.clout.databinding.ListItemGalleryImageBinding
import com.srb.libimgur.models.Image

class FeedRecyclerAdapter() :
    ListAdapter<Image, FeedRecyclerAdapter.FeedViewHolder>(FeedDiffCallBack()) {


    class FeedViewHolder(val binding: ListItemGalleryImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    private class FeedDiffCallBack : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.toString() == newItem.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(
            ListItemGalleryImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val image = getItem(position)
        holder.binding.captionTextView.text = image.title
        holder.binding.imageView.load("https://i.imgur.com/${image.cover}.jpg") {
            placeholder(R.drawable.placeholder_image)
            error(R.drawable.placeholder_image)
        }
    }
}
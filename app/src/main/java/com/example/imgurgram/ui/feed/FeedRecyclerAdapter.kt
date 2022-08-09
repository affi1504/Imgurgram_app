package com.example.imgurgram.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.imgurgram.R
import com.example.imgurgram.databinding.ListItemGalleryImageBinding
import com.example.libimgur.models.Image

class FeedRecyclerAdapter(): ListAdapter<Image, FeedRecyclerAdapter.FeedViewHolder>(FeedDiffCallBack()) {

    class FeedViewHolder(binding: ListItemGalleryImageBinding): RecyclerView.ViewHolder(binding.root) {
            val captionTextView = binding.captionTextView
            val imageView = binding.ItemImageView
            val viewCount = binding.viewsCount
            val likesCount = binding.likesCount
            val dislikesCount = binding.dislikesCount

    }

    private class FeedDiffCallBack: DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.toString() == newItem.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemGalleryImageBinding.inflate(inflater,parent,false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val image = getItem(position)
        holder.captionTextView.text = image.title
        holder.imageView.load("https://i.imgur.com/${image.cover}.jpg"){
            placeholder(R.drawable.placeholder)
        }
        holder.viewCount.text = image.views.toString()
        holder.likesCount.text = image.ups.toString()
        holder.dislikesCount.text = image.downs.toString()
    }
}
package com.example.writerapp.ui.fragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.writerapp.data.model.Story
import com.example.writerapp.databinding.ItemListBinding

class LocationAdapter(private val onItemClick: (Int) -> Unit) : ListAdapter<Story, LocationAdapter.LocationViewHolder>(LocationItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val story = getItem(position)
        holder.onBind(story)
    }

    class LocationViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(story: Story) {
            with(binding) {
                tvName.text = story.location
                tvTitle.text = story.title
            }
        }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(story: Story) {
            itemView.setOnClickListener {
                onItemClick(story.id)
                itemView.setOnClickListener {
                    onItemClick(story.id)
                }
            }
        }
    }
}

class LocationItemCallback : DiffUtil.ItemCallback<Story>() {
    override fun areItemsTheSame(oldItem: Story, newItem: Story) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Story, newItem: Story) = oldItem == newItem
}

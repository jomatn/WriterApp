package com.example.writerapp.ui.fragment.adapters

import OnItemClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.writerapp.data.model.Story
import com.example.writerapp.databinding.ItemListBinding

class StoryAdapter (private val onItemClick: (Int) -> Unit): ListAdapter<Story, StoryAdapter.StoryViewHolder>(StoryItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = getItem(position)
        holder.onBind(story)
    }

    class StoryViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(story: Story) {
            with(binding) {
                tvName.text = story.title
                tvTitle.text = story.genre
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

class StoryItemCallback : DiffUtil.ItemCallback<Story>() {
    override fun areItemsTheSame(oldItem: Story, newItem: Story) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Story, newItem: Story) = oldItem == newItem
}

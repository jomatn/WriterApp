package com.example.writerapp.ui.fragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.writerapp.data.model.Story
import com.example.writerapp.databinding.ItemListBinding

class CharacterAdapter(private val onItemClick: (Int) -> Unit) : ListAdapter<Story, CharacterAdapter.CharacterViewHolder>(CharacterItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val story = getItem(position)
        holder.onBind(story)
    }

    class CharacterViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(story: Story) {
            with(binding) {
                tvName.text = story.name
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

class CharacterItemCallback : DiffUtil.ItemCallback<Story>() {
    override fun areItemsTheSame(oldItem: Story, newItem: Story) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Story, newItem: Story) = oldItem == newItem
}

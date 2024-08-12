package com.example.writerapp.ui.fragment

import OnItemClickListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.writerapp.data.model.Story
import com.example.writerapp.databinding.FragmentListBinding
import com.example.writerapp.ui.fragment.adapters.CharacterAdapter
import com.example.writerapp.ui.fragment.adapters.LocationAdapter
import com.example.writerapp.ui.fragment.adapters.StoryAdapter
import com.example.writerapp.ui.fragment.list.ItemType

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private var itemType: ItemType? = null
    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemType = arguments?.getSerializable("ITEM_TYPE") as? ItemType

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvList.layoutManager = LinearLayoutManager(requireContext())
        val adapter = when (itemType) {
            ItemType.STORY -> StoryAdapter { itemId -> onItemClickListener?.onItemClick(itemId) }
            ItemType.CHARACTER -> CharacterAdapter { itemId -> onItemClickListener?.onItemClick(itemId) }
            ItemType.LOCATION -> LocationAdapter { itemId -> onItemClickListener?.onItemClick(itemId) }
            else -> throw IllegalArgumentException("Unknown item type")
        }
        binding.rvList.adapter = adapter
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }
}

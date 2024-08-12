package com.example.writerapp.ui.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.writerapp.data.model.Story
import com.example.writerapp.databinding.FragmentDetailBinding
import com.example.writerapp.ui.fragment.ListFragment
import com.example.writerapp.ui.fragment.adapters.CharacterAdapter
import com.example.writerapp.ui.fragment.adapters.LocationAdapter
import com.example.writerapp.ui.fragment.adapters.StoryAdapter
import com.example.writerapp.ui.fragment.base.BaseFragment
import com.example.writerapp.ui.fragment.list.ItemType



class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private lateinit var mDetailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDetailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Use args.itemId or any other argument
    }
}

// MainFragment.kt
package com.example.writerapp.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.writerapp.R
import com.example.writerapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() = with(binding) {
        btnStories.setOnClickListener { navigateToListFragment("stories") }
        btnCharacters.setOnClickListener { navigateToListFragment("characters") }
        btnLocations.setOnClickListener { navigateToListFragment("locations") }
    }

    private fun navigateToListFragment(itemType: String) {
        val action = MainFragmentDirections.actionMainFragmentToListFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

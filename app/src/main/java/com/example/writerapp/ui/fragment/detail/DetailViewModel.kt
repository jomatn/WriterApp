// DetailViewModel.kt
package com.example.writerapp.ui.fragment.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.writerapp.data.repository.StoryRepository
import kotlinx.coroutines.launch


class DetailViewModel(
    private val storyRepository: StoryRepository
) : ViewModel() {
    fun getStory(id: Int) = storyRepository.allStories
}

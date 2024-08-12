// ListViewModel.kt
package com.example.writerapp.ui.fragment.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.writerapp.data.model.Story
import com.example.writerapp.data.repository.StoryRepository
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class ListViewModel(
    private val storyRepository: StoryRepository
) : ViewModel() {
    val stories: LiveData<List<Story>> get() = storyRepository.allStories
    fun getStories(): LiveData<List<Story>> = stories
}

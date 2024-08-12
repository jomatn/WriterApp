package com.example.writerapp.data.repository

import androidx.lifecycle.LiveData
import com.example.writerapp.data.dao.StoryDao
import com.example.writerapp.data.model.Story

class StoryRepository(private val storyDao: StoryDao) {

    val allStories: LiveData<List<Story>> = storyDao.getAllStories()

    suspend fun insert(story: Story) {
        storyDao.insertStory(story)
    }
}

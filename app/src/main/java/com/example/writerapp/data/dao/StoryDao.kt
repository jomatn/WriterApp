package com.example.writerapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.writerapp.data.model.Story

@Dao
interface StoryDao {
    @Query("SELECT * FROM stories")
    fun getAllStories(): LiveData<List<Story>>

    @Insert
    suspend fun insertStory(story: Story)

    @Delete
    suspend fun deleteHistory(historyModel: Story)

    @Query("SELECT * FROM stories WHERE id = :id")
    fun getHistoryById(id: Int): LiveData<Story>

    @Update
    suspend fun updateHistory(historyModel: Story)
}
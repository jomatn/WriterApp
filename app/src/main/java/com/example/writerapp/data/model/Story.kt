package com.example.writerapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "stories")
data class Story(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val genre: String,
    val description: String,
    val name: String,
    val location: String,
    val characterDesc : String,
    val locationDesc : String
): Serializable

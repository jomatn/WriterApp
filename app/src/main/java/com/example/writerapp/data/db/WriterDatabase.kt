package com.example.writerapp.data.db

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.writerapp.data.dao.StoryDao
import com.example.writerapp.data.model.Story

@Database(entities = [Story::class], version = 1)
abstract class WriterDatabase : RoomDatabase() {

    abstract fun storyDao(): StoryDao

    companion object{
        @Volatile
        private var INSTANCE : WriterDatabase? = null
        fun getDataBase(context: Context): WriterDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
               val instance = Room.databaseBuilder(
                context.applicationContext,
                WriterDatabase::class.java,
                "writer_database"
            ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
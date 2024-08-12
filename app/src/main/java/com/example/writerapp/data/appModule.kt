// AppModule.kt
package com.example.writerapp.di

import com.example.writerapp.data.db.WriterDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.example.writerapp.data.repository.StoryRepository
import com.example.writerapp.ui.fragment.detail.DetailViewModel
import com.example.writerapp.ui.fragment.list.ListViewModel

val appModule = module {
    // Database and DAO modules
    single { get<WriterDatabase>().storyDao() }

    // Repositories
    single { CharacterRepository(get()) }
    single { LocationRepository(get()) }
    single { StoryRepository(get()) }

    // ViewModels
    viewModel { DetailViewModel(get(), get(), get()) }
    viewModel { ListViewModel(get(), get(), get()) }
}

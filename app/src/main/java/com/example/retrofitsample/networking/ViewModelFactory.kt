package com.example.retrofitsample.networking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitsample.users.repository.UserRepository
import com.example.retrofitsample.users.viewModel.UserViewModel

class ViewModelFactory(private val apiService: ApiService):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel(UserRepository(apiService)) as T
        }
        throw IllegalArgumentException("Unknown Class name")
    }
}
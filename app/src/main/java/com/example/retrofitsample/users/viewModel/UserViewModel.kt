package com.example.retrofitsample.users.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitsample.users.Common
import com.example.retrofitsample.users.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val usersLiveData: MutableLiveData<Common> = MutableLiveData()
    fun getUserLiveData() = usersLiveData

    fun fetchUsers() {
        var response: Response<Common>
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                response = userRepository.fetchUsers()
                usersLiveData.postValue(response.body())
            }
        }
    }
}
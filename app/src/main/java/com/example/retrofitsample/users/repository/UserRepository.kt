package com.example.retrofitsample.users.repository

import com.example.retrofitsample.networking.ApiService
import com.example.retrofitsample.networking.Constants.API_TOKEN
import com.example.retrofitsample.networking.Constants.USERS
import com.example.retrofitsample.users.Common
import retrofit2.Response
import retrofit2.http.GET

class UserRepository(private val apiService: ApiService) {
    suspend fun fetchUsers(): Response<Common> {
        return apiService.getUsers(API_TOKEN)
    }
}
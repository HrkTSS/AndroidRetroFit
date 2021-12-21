package com.example.retrofitsample.networking

import com.example.retrofitsample.networking.Constants.BASE_URL
import com.example.retrofitsample.networking.Constants.USERS
import com.example.retrofitsample.users.Common
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET(USERS)
    suspend fun getUsers(@Header("Authorization") authorization: String): Response<Common>


}
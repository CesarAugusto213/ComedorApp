package com.ecoservicios.comedorapp.data.remote

import com.ecoservicios.comedorapp.data.remote.entities.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface EcoService {
    
    @GET("/api/users")
    suspend fun getUsers(): Response<UserResponse>
    
}
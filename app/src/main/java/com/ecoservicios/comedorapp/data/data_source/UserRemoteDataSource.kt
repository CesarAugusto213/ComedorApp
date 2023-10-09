package com.ecoservicios.comedorapp.data.data_source

import com.ecoservicios.comedorapp.data.remote.EcoService
import com.ecoservicios.comedorapp.data.remote.entities.response.UserResponse
import com.ecoservicios.comedorapp.data.remote.generics.DataResult
import com.ecoservicios.comedorapp.data.remote.generics.safeApiCall
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val api: EcoService) {

    suspend fun getUsers(): DataResult<UserResponse> {
        return safeApiCall {
            api.getUsers()
        }
    }

}
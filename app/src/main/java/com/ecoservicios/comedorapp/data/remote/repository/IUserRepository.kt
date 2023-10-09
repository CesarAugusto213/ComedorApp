package com.ecoservicios.comedorapp.data.remote.repository

import com.ecoservicios.comedorapp.data.remote.entities.response.User
import com.ecoservicios.comedorapp.data.remote.generics.DataResult

interface IUserRepository {

    suspend fun getUsersList(): DataResult<List<User>>

}
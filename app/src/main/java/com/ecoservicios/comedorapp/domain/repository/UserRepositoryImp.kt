package com.ecoservicios.comedorapp.domain.repository

import com.ecoservicios.comedorapp.data.data_source.UserRemoteDataSource
import com.ecoservicios.comedorapp.data.remote.entities.response.User
import com.ecoservicios.comedorapp.data.remote.generics.DataResult
import com.ecoservicios.comedorapp.data.remote.repository.IUserRepository
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val remote: UserRemoteDataSource
) : IUserRepository {
    override suspend fun getUsersList(): DataResult<List<User>> {
        val result = remote.getUsers()

        return when(result) {
            is DataResult.Success -> {
                val user = result.data.content
                DataResult.Success(data = user)
            }

            is DataResult.Error -> {
                DataResult.Error()
            }
        }
    }

}
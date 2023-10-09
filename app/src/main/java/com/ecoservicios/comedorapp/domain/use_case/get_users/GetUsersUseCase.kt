package com.ecoservicios.comedorapp.domain.use_case.get_users

import com.ecoservicios.comedorapp.data.remote.generics.DataResult
import com.ecoservicios.comedorapp.data.remote.repository.IUserRepository
import com.ecoservicios.comedorapp.domain.SimpleUseCase
import com.ecoservicios.comedorapp.domain.mapper.convertToModel
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: IUserRepository
) : SimpleUseCase.WithoutParams<GetUsersResult> {
    override suspend fun invoke(): GetUsersResult {
        val result = repository.getUsersList()

        return when(result) {
            is DataResult.Success -> GetUsersResult.Success(
                listUsers = result.data.convertToModel()
            )

            is DataResult.Error -> GetUsersResult.Error(
                result.message.orEmpty()
            )
        }
    }

}
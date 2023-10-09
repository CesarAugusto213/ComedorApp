package com.ecoservicios.comedorapp.domain.use_case.get_users

import com.ecoservicios.comedorapp.domain.entities.UserModel

sealed class GetUsersResult {

    data class Success(
        val listUsers: List<UserModel>
    ) : GetUsersResult()

    data class Error(
        val message: String
    ) : GetUsersResult()

}
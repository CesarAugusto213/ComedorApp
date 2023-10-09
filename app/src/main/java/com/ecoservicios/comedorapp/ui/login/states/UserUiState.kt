package com.ecoservicios.comedorapp.ui.login.states

import com.ecoservicios.comedorapp.data.local.database.entities.UserEntity
import com.ecoservicios.comedorapp.domain.entities.UserModel

data class UserUiState(
    val listUser: List<UserModel> = emptyList(),
    val loading: Boolean? = false,
    val user: UserEntity? = null,
    val error: String? = null
)
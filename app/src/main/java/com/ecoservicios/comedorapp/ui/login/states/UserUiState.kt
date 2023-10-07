package com.ecoservicios.comedorapp.ui.login.states

import com.ecoservicios.comedorapp.data.local.database.entities.UserEntity

data class UserUiState(
    val loading: Boolean? = false,
    val user: UserEntity? = null
)
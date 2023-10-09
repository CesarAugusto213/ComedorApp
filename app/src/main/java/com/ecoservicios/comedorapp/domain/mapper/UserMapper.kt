package com.ecoservicios.comedorapp.domain.mapper

import com.ecoservicios.comedorapp.data.remote.entities.response.User
import com.ecoservicios.comedorapp.domain.entities.UserModel

fun User.convertToModel() = UserModel(
    id = id,
    user = user,
    password = password,
    description = description,
    status = status,
    dateRegion = dateRegion,
    type = type
)

fun List<User>.convertToModel(): List<UserModel> {
    return map(User::convertToModel)
}
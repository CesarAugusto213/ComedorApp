package com.ecoservicios.comedorapp.data.remote.entities.response

import com.squareup.moshi.Json

data class UserResponse(
    @field:Json(name = "content") val content: List<User>
)
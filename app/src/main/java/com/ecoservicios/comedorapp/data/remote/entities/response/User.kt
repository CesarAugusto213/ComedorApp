package com.ecoservicios.comedorapp.data.remote.entities.response

import com.squareup.moshi.Json

data class User(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "user") val user: String,
    @field:Json(name = "password") val password: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "dateRegion") val dateRegion: String,
    @field:Json(name = "type") val type: String
)
package com.ecoservicios.comedorapp.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val id: String,
    val user: String,
    val password: String,
    val description: String,
    val status: String,
    val dateRegion: String,
    val type: String
) : Parcelable
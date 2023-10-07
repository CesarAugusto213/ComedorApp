package com.ecoservicios.comedorapp.data.local.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sedes")
data class CampusEntity(
    @PrimaryKey
    @ColumnInfo(name = "k03_key")
    val id: String,

    @ColumnInfo(name = "k03_descripcion")
    val desc: String,

    @ColumnInfo(name = "k03_direccion")
    val address: String,

    @ColumnInfo(name = "k03_estado")
    val status: String = "A"
)
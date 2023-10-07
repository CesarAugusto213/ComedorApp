package com.ecoservicios.comedorapp.data.local.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "usuarios",
    foreignKeys = [
        ForeignKey(
            entity = CampusEntity::class,
            parentColumns = ["k03_key"],
            childColumns = ["k01_sede"]
        )
    ],
    indices = [Index("k01_sede")]
)
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "k01_key")
    val id: String,

    @ColumnInfo(name = "k01_usuario")
    val user: String,

    @ColumnInfo(name = "k01_clave")
    val password: String,

    @ColumnInfo(name = "k01_sede")
    val idCampus: String,

    @ColumnInfo(name = "k01_estado")
    val status: String = "A",

    @ColumnInfo(name = "k01_fechareg")
    val dateRegion: String,

    @ColumnInfo(name = "k01_tipo")
    val type: String = "G"
)
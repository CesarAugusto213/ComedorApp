package com.ecoservicios.comedorapp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ecoservicios.comedorapp.data.local.database.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM usuarios WHERE k01_usuario = :user AND k01_clave = :password")
    suspend fun searchUserToLogIn(user: String, password: String): UserEntity

}
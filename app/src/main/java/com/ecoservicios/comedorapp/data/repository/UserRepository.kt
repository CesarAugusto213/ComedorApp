package com.ecoservicios.comedorapp.data.repository

import com.ecoservicios.comedorapp.data.local.database.dao.UserDao
import com.ecoservicios.comedorapp.data.local.database.entities.UserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun searchUserToLogIn(user: String, password: String): UserEntity {
        return userDao.searchUserToLogIn(user, password)
    }

}
package com.ecoservicios.comedorapp.data.repository

import com.ecoservicios.comedorapp.data.local.database.dao.CampusDao
import com.ecoservicios.comedorapp.data.local.database.entities.CampusEntity
import javax.inject.Inject

class CampusRepository @Inject constructor(private val campusDao: CampusDao) {
    suspend fun insertCampus(campus: CampusEntity) {
        campusDao.insertCampus(campus)
    }

    suspend fun getCampus(): List<CampusEntity>{
        return campusDao.getCampus()
    }

}
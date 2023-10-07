package com.ecoservicios.comedorapp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ecoservicios.comedorapp.data.local.database.entities.CampusEntity

@Dao
interface CampusDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCampus(campus: CampusEntity)

}
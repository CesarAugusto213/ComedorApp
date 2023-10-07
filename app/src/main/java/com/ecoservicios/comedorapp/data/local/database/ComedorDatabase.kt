package com.ecoservicios.comedorapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ecoservicios.comedorapp.data.local.database.dao.CampusDao
import com.ecoservicios.comedorapp.data.local.database.entities.CampusEntity

@Database(
    entities = [CampusEntity::class],
    version = 1
)
abstract class ComedorDatabase : RoomDatabase() {
    abstract fun campusDao(): CampusDao

}
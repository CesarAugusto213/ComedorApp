package com.ecoservicios.comedorapp.data.di

import android.app.Application
import androidx.room.Room
import com.ecoservicios.comedorapp.data.local.database.ComedorDatabase
import com.ecoservicios.comedorapp.data.local.database.dao.CampusDao
import com.ecoservicios.comedorapp.data.local.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): ComedorDatabase {
        return Room.databaseBuilder(application, ComedorDatabase::class.java, "ComedorDatabase")
            .build()
    }

    @Provides
    @Singleton
    fun provideCampusDao(appDatabase: ComedorDatabase): CampusDao {
        return appDatabase.campusDao()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: ComedorDatabase): UserDao {
        return appDatabase.userDao()
    }

}
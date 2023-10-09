package com.ecoservicios.comedorapp.data.di

import com.ecoservicios.comedorapp.data.data_source.UserRemoteDataSource
import com.ecoservicios.comedorapp.data.remote.EcoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun userRemoteDataSourceModule(api: EcoService) = UserRemoteDataSource(api)

}
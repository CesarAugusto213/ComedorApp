package com.ecoservicios.comedorapp.domain.di

import com.ecoservicios.comedorapp.data.data_source.UserRemoteDataSource
import com.ecoservicios.comedorapp.data.remote.repository.IUserRepository
import com.ecoservicios.comedorapp.domain.repository.UserRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun getUsers(remote: UserRemoteDataSource): IUserRepository = UserRepositoryImp(remote)

}
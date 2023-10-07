package com.ecoservicios.comedorapp.ui.login

import androidx.lifecycle.ViewModel
import com.ecoservicios.comedorapp.data.local.database.entities.CampusEntity
import com.ecoservicios.comedorapp.data.local.database.entities.UserEntity
import com.ecoservicios.comedorapp.data.repository.CampusRepository
import com.ecoservicios.comedorapp.data.repository.UserRepository
import com.ecoservicios.comedorapp.ui.login.states.UserUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val campusRepository: CampusRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private var _stateUser = MutableStateFlow(UserUiState())

    val stateUser: StateFlow<UserUiState> get() = _stateUser.asStateFlow()

    suspend fun insertCampus(campus: CampusEntity) {
        campusRepository.insertCampus(campus)
    }

    suspend fun getCampus() : List<CampusEntity> {
        return campusRepository.getCampus()
    }

    suspend fun insertUser(user: UserEntity) {
        userRepository.insertUser(user)
    }

    suspend fun searchUserToLogIn(user: String, password: String){
        val result =  userRepository.searchUserToLogIn(user,password)
        _stateUser.value = UserUiState(user = result)
    }

}
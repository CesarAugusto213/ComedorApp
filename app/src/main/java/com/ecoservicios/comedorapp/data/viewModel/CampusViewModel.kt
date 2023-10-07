package com.ecoservicios.comedorapp.data.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ecoservicios.comedorapp.data.local.database.entities.CampusEntity
import com.ecoservicios.comedorapp.data.repository.CampusRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CampusViewModel @Inject constructor(private val campusRepository: CampusRepository) : ViewModel() {

    suspend fun insertCampus(campus: CampusEntity) {
        campusRepository.insertCampus(campus)
        Log.d("ViewModel: ", "Ingrese")
    }

}
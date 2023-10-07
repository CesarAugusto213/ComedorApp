package com.ecoservicios.comedorapp.util

import java.text.SimpleDateFormat
import java.util.Date

object Extension {

    fun getCurrentDate() : String {
        val date = Date()
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return simpleDateFormat.format(date)
    }

}
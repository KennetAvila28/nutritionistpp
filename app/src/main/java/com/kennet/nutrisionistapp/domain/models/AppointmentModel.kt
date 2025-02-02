package com.kennet.nutrisionistapp.domain.models

import com.kennet.nutrisionistapp.domain.enums.AppointmentStatus
import com.kennet.nutrisionistapp.domain.enums.AppointmentType
import java.util.Date

data class AppointmentModel(
    val id:Long,
    val date: Date,
    val clientName:String,
    val status: AppointmentStatus = AppointmentStatus.Scheduled,
    val type: AppointmentType = AppointmentType.FirstVisit,
    val notes:String,
    val clientPhone:String = "",
    val clientEmail: String = ""
)

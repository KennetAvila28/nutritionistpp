package com.kennet.nutrisionistapp.data.roomEntities

import androidx.room.Entity
import com.kennet.nutrisionistapp.domain.enums.AppointmentStatus
import com.kennet.nutrisionistapp.domain.enums.AppointmentType
import java.util.Date

@Entity(tableName = "appointments")
data class AppointmentEntity(
    val date: Date,
    val clientName:String,
    val status: AppointmentStatus = AppointmentStatus.Scheduled,
    val type: AppointmentType = AppointmentType.FirstVisit,
    val notes:String,
    val clientPhone:String = "",
    val clientEmail: String = ""
) : BaseEntity()





package com.kennet.nutrisionistapp.domain.entities

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "appointments")
data class AppointmentEntity(
    val date: Date,
    val clientName:String,
    val status:AppointmentStatus=AppointmentStatus.Scheduled,
    val type: AppointmentType = AppointmentType.FirstVisit,
    val notes:String,
    val clientPhone:String = "",
    val clientEmail: String = ""
) : BaseEntity()

enum class AppointmentStatus(val id: String){
    Scheduled("Programada"),
    Completed("Completada"),
    Cancelled("Cancelada")


}

enum class AppointmentType(val id: String){
    FirstVisit("Primera Visita"),
    Follow("Seguimiento"),
    Control("Control")
}

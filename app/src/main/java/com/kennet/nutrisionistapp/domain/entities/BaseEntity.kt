package com.kennet.nutrisionistapp.domain.entities

import androidx.room.PrimaryKey
import java.util.Date

abstract class BaseEntity {
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0
    val isDelete:Boolean = false
    val createAt: Long =System.currentTimeMillis()
}
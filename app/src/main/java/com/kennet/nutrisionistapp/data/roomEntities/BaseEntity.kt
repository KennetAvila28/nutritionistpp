package com.kennet.nutrisionistapp.data.roomEntities

import androidx.room.PrimaryKey

abstract class BaseEntity {
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0
    val isDelete:Boolean = false
    val createAt: Long =System.currentTimeMillis()
}
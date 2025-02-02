package com.kennet.nutrisionistapp.data.daos

import androidx.room.Query
import com.kennet.nutrisionistapp.data.roomEntities.AppointmentEntity
import kotlinx.coroutines.flow.Flow

abstract class AppointmentDao : BaseDao<AppointmentEntity>() {
    @Query("SELECT * FROM products")
    abstract fun getAll(): Flow<List<AppointmentEntity>>

    @Query("SELECT * FROM products WHERE id = :id")
    abstract suspend fun getById(id: Long): AppointmentEntity?

}
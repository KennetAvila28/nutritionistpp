package com.kennet.nutrisionistapp.domain.repositories

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import arrow.core.Either
import com.kennet.nutrisionistapp.domain.error.AppError
import com.kennet.nutrisionistapp.domain.models.AppointmentModel
import kotlinx.coroutines.flow.Flow

interface BaseRepository<T> {
    suspend fun getAll(): Either<AppError, Flow<List<T>>>
    suspend  fun insert(entity:T):Either<AppError,Boolean>

    suspend  fun insertAll(entities:List<T>):Either<AppError,Boolean>

    suspend  fun update(entity: T):Either<AppError,Boolean>
    suspend  fun softDelete(entity: T):Either<AppError,Boolean>

    suspend  fun logicDelete(isDelete: Boolean):Either<AppError,Boolean>
    suspend  fun getById(id: Long):Either<AppError,T>

}
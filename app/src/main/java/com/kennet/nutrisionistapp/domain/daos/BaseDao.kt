package com.kennet.nutrisionistapp.domain.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
abstract class BaseDao<T>{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(entity:T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAll(entities:List<T>)

    @Update
    abstract suspend fun update(entity: T)
    @Delete
    abstract suspend fun softDelete(entity: T)

    abstract suspend fun logicDelete(isDelete: Boolean)
}
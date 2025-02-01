package com.kennet.nutrisionistapp.domain.daos

import androidx.room.Dao
import androidx.room.Query
import com.kennet.nutrisionistapp.domain.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ProductDao: BaseDao<ProductEntity>() {
    @Query("SELECT * FROM products")
    abstract fun getAll(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM products WHERE id = :id")
    abstract suspend fun getById(id: Long): ProductEntity?


}

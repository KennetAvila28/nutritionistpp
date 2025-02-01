package com.kennet.nutrisionistapp.domain.daos

import com.kennet.nutrisionistapp.domain.entities.ProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductDaoImpl @Inject constructor(
    private val productDao: ProductDao
) {
     fun getAll(): Flow<List<ProductEntity>> = productDao.getAll()

     suspend fun getById(id: Long): ProductEntity? = productDao.getById(id)

     suspend fun insert(entity: ProductEntity) = productDao.insert(entity)

     suspend fun insertAll(entities: List<ProductEntity>) =productDao.insertAll(entities)

     suspend fun update(entity: ProductEntity) = productDao.update(entity)

     suspend fun softDelete(entity: ProductEntity) = productDao.softDelete(entity)

     suspend fun logicDelete(isDeleted: Boolean) = productDao.logicDelete(isDeleted)
}
package com.kennet.nutrisionistapp.data.repositories

import arrow.core.Either
import arrow.core.raise.catch
import arrow.core.raise.either
import com.kennet.nutrisionistapp.data.daos.ProductDao
import com.kennet.nutrisionistapp.data.roomEntities.ProductEntity
import com.kennet.nutrisionistapp.domain.error.AppError
import com.kennet.nutrisionistapp.domain.mappers.ProductMapper
import com.kennet.nutrisionistapp.domain.models.ProductModel
import com.kennet.nutrisionistapp.domain.repositories.BaseRepository
import com.kennet.nutrisionistapp.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao,
     private val productMapper: ProductMapper
):ProductRepository {
     override suspend fun getAll(): Either<AppError, Flow<List<ProductModel>>> = either {
          catch({
               val products = productDao.getAll().map { list ->
                    list.map { productMapper.toDomain(it) }
               }
               products
          }){throwable: Throwable -> raise(AppError.UnknownError(throwable)) }
     }

     override suspend fun insert(entity: ProductModel): Either<AppError, Boolean> {
          TODO("Not yet implemented")
     }

     override suspend fun insertAll(entities: List<ProductModel>): Either<AppError, Boolean> {
          TODO("Not yet implemented")
     }

     override suspend fun update(entity: ProductModel): Either<AppError, Boolean> {
          TODO("Not yet implemented")
     }

     override suspend fun softDelete(entity: ProductModel): Either<AppError, Boolean> {
          TODO("Not yet implemented")
     }

     override suspend fun logicDelete(isDelete: Boolean): Either<AppError, Boolean> {
          TODO("Not yet implemented")
     }

     override suspend fun getById(id: Long): Either<AppError, ProductModel> {
          TODO("Not yet implemented")
     }


}
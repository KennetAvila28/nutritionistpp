package com.kennet.nutrisionistapp.domain.usecases

import arrow.core.Either
import com.kennet.nutrisionistapp.domain.error.AppError
import com.kennet.nutrisionistapp.domain.models.ProductModel
import com.kennet.nutrisionistapp.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): Either<AppError, Flow<List<ProductModel>>> =repository.getAll()
}
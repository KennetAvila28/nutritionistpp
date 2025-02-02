package com.kennet.nutrisionistapp.domain.mappers

import com.kennet.nutrisionistapp.data.roomEntities.ProductEntity
import com.kennet.nutrisionistapp.domain.models.ProductModel
import org.mapstruct.Mapper

@Mapper
interface ProductMapper{
    fun toDomain(entity: ProductEntity): ProductModel
}
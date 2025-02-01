package com.kennet.nutrisionistapp.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "products")
data class ProductEntity(

    val name: String,
    val stock: Int,
    val price: Double,
    val cost: Double,
    val gain: Double,
    val description:String
):BaseEntity()

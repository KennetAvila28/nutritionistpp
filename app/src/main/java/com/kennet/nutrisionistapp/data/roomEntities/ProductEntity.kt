package com.kennet.nutrisionistapp.data.roomEntities

import androidx.room.Entity

@Entity(tableName = "products")
data class ProductEntity(

    val name: String,
    val stock: Int,
    val price: Double,
    val cost: Double,
    val gain: Double,
    val description:String
): BaseEntity()

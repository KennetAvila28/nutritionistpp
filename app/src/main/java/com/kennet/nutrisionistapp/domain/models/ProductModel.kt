package com.kennet.nutrisionistapp.domain.models

data class ProductModel(
val id:Long,
val name: String,
val stock: Int,
val price: Double,
val cost: Double,
val gain: Double,
val description:String
)

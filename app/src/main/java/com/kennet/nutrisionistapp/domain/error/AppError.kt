package com.kennet.nutrisionistapp.domain.error

sealed class AppError {
    data class DatabaseError(val message:String) : AppError()
    data class NetworkError(val message:String) : AppError()
    data class UnknownError(val throwable: Throwable) : AppError()
}
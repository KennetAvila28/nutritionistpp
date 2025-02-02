package com.kennet.nutrisionistapp.data.repositories

import arrow.core.Either
import arrow.core.raise.catch
import arrow.core.raise.either
import com.kennet.nutrisionistapp.data.daos.AppointmentDao
import com.kennet.nutrisionistapp.domain.error.AppError
import com.kennet.nutrisionistapp.domain.mappers.AppointmentMapper
import com.kennet.nutrisionistapp.domain.models.AppointmentModel
import com.kennet.nutrisionistapp.domain.repositories.AppointmentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppointmentRepositoryImpl @Inject constructor(
    private val appointmentDao: AppointmentDao,
    private val appointmentMapper: AppointmentMapper
): AppointmentRepository {
    override suspend fun getAll(): Either<AppError, Flow<List<AppointmentModel>>> = either {
         catch({
             val appointments = appointmentDao.getAll().map {list->
                 list.map { appointmentMapper.toDomain(it) }
             }
             appointments
         }){throwable: Throwable -> raise(AppError.UnknownError(throwable)) }
    }

    override suspend fun insert(entity: AppointmentModel): Either<AppError, Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun insertAll(entities: List<AppointmentModel>): Either<AppError, Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun update(entity: AppointmentModel): Either<AppError, Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun softDelete(entity: AppointmentModel): Either<AppError, Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun logicDelete(isDelete: Boolean): Either<AppError, Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: Long): Either<AppError, AppointmentModel> {
        TODO("Not yet implemented")
    }


}
package com.kennet.nutrisionistapp.domain.mappers

import com.kennet.nutrisionistapp.data.roomEntities.AppointmentEntity
import com.kennet.nutrisionistapp.domain.models.AppointmentModel
import org.mapstruct.Mapper

@Mapper
interface AppointmentMapper {
    fun toDomain(entity:AppointmentEntity):AppointmentModel
}
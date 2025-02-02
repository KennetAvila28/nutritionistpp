package com.kennet.nutrisionistapp.di.modules

import com.kennet.nutrisionistapp.domain.mappers.AppointmentMapper
import com.kennet.nutrisionistapp.domain.mappers.ProductMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun provideAppointmentMapper(): AppointmentMapper = Mappers.getMapper(AppointmentMapper::class.java)

    @Provides
    fun provideProductMapper(): ProductMapper = Mappers.getMapper(ProductMapper::class.java)
}
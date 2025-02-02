package com.kennet.nutrisionistapp.di.modules

import android.content.Context
import com.kennet.nutrisionistapp.data.AppDatabase
import com.kennet.nutrisionistapp.data.daos.AppointmentDao
import com.kennet.nutrisionistapp.data.daos.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideProductDao(database: AppDatabase): ProductDao = database.productDao()
    @Provides
    fun provideAppointmentDao(database: AppDatabase): AppointmentDao = database.appointmentDao()
}
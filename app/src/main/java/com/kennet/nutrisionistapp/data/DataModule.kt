package com.kennet.nutrisionistapp.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
@Provides
fun provideAppDatabase(@ApplicationContext context: Context):AppDataBase{
    return  Room.databaseBuilder(context,AppDatabase)
}
}
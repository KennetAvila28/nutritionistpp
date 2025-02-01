package com.kennet.nutrisionistapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kennet.nutrisionistapp.domain.entities.AppointmentEntity
import com.kennet.nutrisionistapp.domain.entities.ProductEntity

@Database(
    entities = [
        ProductEntity::class,
        AppointmentEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase:RoomDatabase() {
    abstract fun productDao():ProductDao

    abstract fun appointmentDao():AppointmentDao
    companion object{
        @Volatile
        private var INSTANCE:AppDatabase? = null

        fun getInstance(context: Context):AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "nutri_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
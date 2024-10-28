package com.example.mywhislistapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Wish::class],
    version = 1,
    exportSchema = false
)
abstract class wishDatabase: RoomDatabase()
{
    abstract fun wishDao():wishDAO
}
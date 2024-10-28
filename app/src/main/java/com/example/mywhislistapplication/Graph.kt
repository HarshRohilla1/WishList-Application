package com.example.mywhislistapplication

import android.content.Context
import androidx.room.Room
import com.example.mywhislistapplication.data.Wishrepository
import com.example.mywhislistapplication.data.wishDatabase

object Graph {
    lateinit var database:wishDatabase

    val wishrepository by lazy {
        Wishrepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context,wishDatabase::class.java,"wishlist.db").build()
    }

}
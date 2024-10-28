package com.example.mywhislistapplication.data

import kotlinx.coroutines.flow.Flow

class Wishrepository(private val wishDao: wishDAO) {

    suspend fun addAWish(wish:Wish){
        wishDao.addAWish(wish)
    }

    fun getWish(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getAWishById(id:Long):Flow<Wish>
    {
        return wishDao.getAWishById(id)
    }

    suspend fun updateAWish(wish:Wish)
    {
        wishDao.updateAWish(wish)
    }
    suspend fun deleteAWish(wish:Wish)
    {
        wishDao.deleteAWish(wish)
    }

}
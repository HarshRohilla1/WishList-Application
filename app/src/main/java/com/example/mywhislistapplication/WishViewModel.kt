package com.example.mywhislistapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywhislistapplication.data.Wish
import com.example.mywhislistapplication.data.Wishrepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository:Wishrepository = Graph.wishrepository
):ViewModel() {

    var WishTitleState by mutableStateOf("")
    var WishDescriptionState by mutableStateOf("")


    fun onWishTitleChanged(newString:String){
        WishTitleState = newString
    }

    fun onWishDescriptionChanged(newString:String){
        WishDescriptionState = newString
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWish()
        }
    }
    fun getAWishById(id:Long):Flow<Wish>
    {
       return wishRepository.getAWishById(id)

    }
    fun addWish(wish:Wish)
    {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addAWish(wish = wish)
        }
    }
    fun updateWish(wish:Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateAWish(wish = wish)
        }
    }
    fun deleteWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteAWish(wish = wish)
            getAllWishes = wishRepository.getWish()
        }
    }
}




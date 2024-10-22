package com.example.mywhislistapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WishViewModel:ViewModel() {

    var WishTitleState by mutableStateOf("")
    var WishDescriptionState by mutableStateOf("")


    fun onWishTitleChanged(title:String){
        WishTitleState = title
    }

    fun onWishDescriptionChanged(description:String){
        WishDescriptionState = description
    }

}
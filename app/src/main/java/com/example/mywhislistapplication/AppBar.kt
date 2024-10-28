package com.example.mywhislistapplication

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AppBarView(
    title:String,
    onBackNavClicked:()->Unit = {}
)
{
    val navigationIcon: (@Composable () -> Unit)? =
    {
        if(!title.contains("WishList")) {
            IconButton(onClick = { onBackNavClicked() })
            {
                Icon(modifier = Modifier.padding( top = 15.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )

            }
        }
        else
        {
            null
        }
    }



   TopAppBar(title = {
       Text(text = title ,
           color = colorResource(id = R.color.white),
           modifier = Modifier
               .padding( top = 15.dp)
               .heightIn(max = 24.dp),
           fontWeight = FontWeight.Bold,
           fontSize = 22.sp)
   },
       elevation = 10.dp,
       backgroundColor = colorResource(id = R.color.background),
       navigationIcon = navigationIcon
   )

}
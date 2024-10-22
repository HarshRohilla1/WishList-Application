package com.example.mywhislistapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mywhislistapplication.data.Wish

@Composable
fun HomeView(modifier: Modifier,
             viewModel: WishViewModel,
             navController: NavController
)
{
    Scaffold(
        topBar = { AppBarView(title = "WishList")},
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 25.dp),
                contentColor = Color.White,
                backgroundColor = Color.Blue,
                onClick = {
                    navController.navigate(Screen.AddScreen.route)
             })
            {
                Icon(imageVector = Icons.Default.Add ,
                    contentDescription = null)

            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(it)
        ) {

        }
    }
}

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit){

    Card( modifier = Modifier.fillMaxWidth().padding(16.dp).clickable { onClick() },
        elevation = 8.dp,
        backgroundColor = Color.White
    )
    {
        Column(
            modifier = Modifier.padding(16.dp)
        )
        {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.title)
        }
    }
}
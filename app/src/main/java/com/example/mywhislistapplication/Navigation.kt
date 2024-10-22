package com.example.mywhislistapplication

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mywhislistapplication.data.Wish

@Composable
fun Navigation(viewModel: WishViewModel = viewModel(),
               navController: NavHostController= rememberNavController(),
               modifier: Modifier)
{
    NavHost(navController = navController,
        startDestination = Screen.HomeScreen.route)
    {
        composable(Screen.HomeScreen.route)
        {
            HomeView(modifier= Modifier,viewModel=viewModel,navController=navController)
        }
        composable(Screen.AddScreen.route)
        {
            AddEditDetailView(id = 0L,
                viewModel = viewModel,
                navController = navController )
        }


    }

}
package com.example.inventory.Navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inventory.AllScreens.AllScreens
import com.example.inventory.Screens.AddFarmerScreen
import com.example.inventory.Screens.FarmersListScreen
import com.example.inventory.Screens.HomeScreen
import com.example.inventory.Screens.LoginScreen
import com.example.inventory.Screens.SignUpScreen
import com.example.inventory.Viewmodel.LogInSignInViewmodel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Navigation (){
val navController = rememberNavController()


    val vm:LogInSignInViewmodel= hiltViewModel()
    
    NavHost(navController = navController, startDestination = AllScreens.SignUpScreen.name )
    {
        composable(AllScreens.SignUpScreen.name){
            SignUpScreen(navController = navController, viewModel = vm)
        }

        composable(AllScreens.HomeScreen.name){
            HomeScreen(navController)
        }

        composable(AllScreens.LogInScreen.name){
            LoginScreen(navController = navController, viewModel = vm)
        }

        composable(AllScreens.AddFarmerScreen.name){
            AddFarmerScreen(viewmodel = vm)
        }

        composable(AllScreens.FarmersListScreen.name){
            FarmersListScreen(viewmodel = vm)
        }

    };
}
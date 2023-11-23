package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.screen.InfoScreen

@Composable
fun NavGraph(navController : NavHostController) {

    NavHost(navController, startDestination = "info"){
        composable(Screens.Info.route, arguments = listOf(
            navArgument(name = "name_key"){type = NavType.StringType},
            navArgument(name = "price_key"){type = NavType.IntType},
            navArgument(name = "img_key"){type = NavType.IntType}
        )){
            navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString("name_key")
            val price = navBackStackEntry.arguments?.getString("price_key")
            val img = navBackStackEntry.arguments?.getString("img_key")
            InfoScreen(name.toString(),price.toString().toInt(),img.toString().toInt())
        }

    }
}
package com.example.ripleyapp.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ripleyapp.view.CalculadoraView
import com.example.ripleyapp.view.CategoriasView
import com.example.ripleyapp.view.FirstView
import com.example.ripleyapp.view.HomeView

@Composable
fun NavManager(){
    val navController = rememberNavController();
    NavHost(navController = navController , startDestination = "First"){
        composable("First"){
            FirstView(navController)
        }
        composable("Home"){
            HomeView(navController)
        }
        composable("Categorias"){
            CategoriasView(navController)
        }


        composable("Calculadora/{selectedItem}"){
                backStackEntry ->
            val selectedItem = backStackEntry.arguments?.getString("selectedItem") ?: ""
            CalculadoraView(navController, selectedItem)
        }
    }
}
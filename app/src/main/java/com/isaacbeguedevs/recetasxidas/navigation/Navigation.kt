package com.isaacbeguedevs.recetasxidas.navigation

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.isaacbeguedevs.recetasxidas.pantallas.BarraSuperior
import com.isaacbeguedevs.recetasxidas.pantallas.PantallaPrincipal
import com.isaacbeguedevs.recetasxidas.pantallas.PantallaReceta

@SuppressLint("NewApi")
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.PantallaPrincipal.route
    ) {
        composable(Screen.PantallaPrincipal.route){
            PantallasConLayout({ PantallaPrincipal(navController = navController) },
                navController
            )
        }
        composable(Screen.PantallaReceta.route){
            PantallasConLayout({ PantallaReceta(navController = navController) },
                navController
            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PantallasConLayout(composable: @Composable () -> Unit, navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = { BarraSuperior(navController = navController) }
    ) {
        composable()
    }
}
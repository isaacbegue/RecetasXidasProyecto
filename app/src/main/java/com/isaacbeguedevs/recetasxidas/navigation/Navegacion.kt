package com.isaacbeguedevs.recetasxidas.navigation

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.isaacbeguedevs.recetasxidas.layouts.BarraSuperior
import com.isaacbeguedevs.recetasxidas.pantallas.PantallaAutores
import com.isaacbeguedevs.recetasxidas.pantallas.PantallaPrincipal
import com.isaacbeguedevs.recetasxidas.pantallas.PantallaReceta
import com.isaacbeguedevs.recetasxidas.pantallas.PantallaTipoDeCambio

@SuppressLint("NewApi")
@Composable
fun Navegacion(context: Context, varGlobales: MutableMap<String, Any>) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RutasPantallas.PantallaPrincipal.route
    ) {
        composable(RutasPantallas.PantallaPrincipal.route){
            PantallasConLayout({ PantallaPrincipal(navController = navController, context, varGlobales) },
                navController
            )
        }
        composable(RutasPantallas.PantallaReceta.route){
            PantallasConLayout({ PantallaReceta(navController = navController, context, varGlobales) },
                navController
            )
        }
        composable(RutasPantallas.PantallaAutores.route){
            PantallasConLayout({ PantallaAutores() },
                navController
            )
        }
        composable(RutasPantallas.PantallaTipoDeCambio.route){
            PantallasConLayout({ PantallaTipoDeCambio() },
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

enum class RutasPantallas(val route: String) {
    PantallaPrincipal("pantalla_principal"),
    PantallaReceta("pantalla_receta"),
    PantallaAutores("pantalla_autores"),
    PantallaTipoDeCambio("pantalla_tipo_de_cambio")
}

package com.isaacbeguedevs.recetasxidas.layouts


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.isaacbeguedevs.recetasxidas.R
import com.isaacbeguedevs.recetasxidas.navigation.RutasPantallas


@Composable
fun BarraSuperior(navController: NavController){

    val pantallaActual: String = navController.currentBackStackEntry?.destination?.route!!

    var expanded by remember { mutableStateOf(false) }

    /* Top bar de pruebas*/
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.isologo),
                contentDescription = "logo RecetasXidas",
                Modifier.height(60.dp)
                    .clickable {
                        navController.navigate(RutasPantallas.PantallaPrincipal.route) {
                            if(pantallaActual != RutasPantallas.PantallaPrincipal.route) {
                                popUpTo(pantallaActual){
                                    inclusive = true
                                }
                            }
                        }
                    }
            )
        },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menú")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(onClick = {
                    expanded = false
                }) {
                    Text(
                        text = "Autores registrados",
                        modifier = Modifier
                            .clickable {
                                navController.navigate(RutasPantallas.PantallaAutores.route) {
                                    if(pantallaActual != RutasPantallas.PantallaAutores.route) {
                                        popUpTo(pantallaActual){
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                    )
                }
                DropdownMenuItem(onClick = {
                    expanded = false
                }) {
                    Text(
                        text = "Tipo de cambio",
                        modifier = Modifier
                            .clickable {
                                navController.navigate(RutasPantallas.PantallaTipoDeCambio.route) {
                                    if(pantallaActual != RutasPantallas.PantallaTipoDeCambio.route) {
                                        popUpTo(pantallaActual){
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                    )
                }
                DropdownMenuItem(onClick = {
                    expanded = false
                }) {
                    Text(
                        text = "Google Maps",
                        modifier = Modifier
                            .clickable {
                                navController.navigate(RutasPantallas.PantallaMapa.route) {
                                    if(pantallaActual != RutasPantallas.PantallaMapa.route) {
                                        popUpTo(pantallaActual){
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                    )
                }
                DropdownMenuItem(onClick = {
                    expanded = false
                }) {
                    Text(
                        text = "Inicio Sesión",
                        modifier = Modifier
                            .clickable {
                                navController.navigate(RutasPantallas.PantallaInicioSesion.route) {
                                    if(pantallaActual != RutasPantallas.PantallaInicioSesion.route) {
                                        popUpTo(pantallaActual){
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                    )
                }
                DropdownMenuItem(onClick = {
                    expanded = false
                }) {
                    Text(
                        text = "Registrarse",
                        modifier = Modifier
                            .clickable {
                                navController.navigate(RutasPantallas.PantallaRegistrarse.route) {
                                    if(pantallaActual != RutasPantallas.PantallaRegistrarse.route) {
                                        popUpTo(pantallaActual){
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                    )
                }
            }

        }
    )

}


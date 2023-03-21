package com.isaacbeguedevs.recetasxidas.pantallas


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.isaacbeguedevs.recetasxidas.R
import com.isaacbeguedevs.recetasxidas.navigation.Screen


@Composable
fun BarraSuperior(navController: NavController){
    
    TopAppBar(){
        Row(
            modifier = Modifier
                .background(color = MaterialTheme.colors.primary)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.isologo),
                contentDescription = "logo RecetasXidas",
                Modifier.height(60.dp)
                    .clickable { navController.navigate(Screen.PantallaPrincipal.route) {
                        if(!navController.equals(Screen.PantallaPrincipal.route)) {
                            popUpTo(Screen.PantallaPrincipal.route){
                                inclusive = true
                            }
                        }
                    } }
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_menu_24),
                contentDescription = "menu hamburguesa",
                modifier = Modifier
                    .height(60.dp)
                    .padding(horizontal = 15.dp)
                    .clickable { }
            )
        }
    }

}


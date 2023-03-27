package com.isaacbeguedevs.recetasxidas.elementos

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.isaacbeguedevs.recetasxidas.navigation.RutasPantallas

@Composable
fun CardsPantallaPrincipal(
    idImage: Int,
    imageDescription: String,
    tituloReceta: String,
    idReceta: Int,
    varGlobales: MutableMap<String, Any>,
    navController: NavController
) {
    val pantallaActual: String = navController.currentBackStackEntry?.destination?.route!!

    Column(
        modifier = Modifier.fillMaxWidth()
            .clickable {
                varGlobales["idReceta"] = idReceta
                navController.navigate(RutasPantallas.PantallaReceta.route) {
                    if(pantallaActual != RutasPantallas.PantallaReceta.route) {
                        popUpTo(pantallaActual){
                            inclusive = true
                        }
                    }
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally
    )  {
        Card(modifier = Modifier
            .width(250.dp)
            .padding(vertical = 10.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 5.dp,

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = idImage),
                    contentDescription = imageDescription,
                    modifier = Modifier
                        .height(120.dp)
                        .clip(RoundedCornerShape(20.dp)),
                )
                Text(text = tituloReceta, fontSize = 18.sp, textAlign = TextAlign.Center)
            }
        }
    }
}
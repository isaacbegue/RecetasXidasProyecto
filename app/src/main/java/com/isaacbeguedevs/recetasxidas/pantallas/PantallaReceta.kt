package com.isaacbeguedevs.recetasxidas.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.foundation.layout.R


@Composable
fun PantallaReceta(
    navController: NavController
) {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val args = requireNotNull(navBackStackEntry).arguments
//    val idImage = args?.getInt("idImage",0)
//    val imageDescription = args?.getString("imageDescription").orEmpty()
//    val tituloReceta = args?.getString("tituloReceta").orEmpty()

    val idImage = com.isaacbeguedevs.recetasxidas.R.drawable.espagueti_a_la_carbonara
    val imageDescription = "holis"
    val tituloReceta = "hoiasdf"

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxSize()
    ) {
        Text(
            text = tituloReceta,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        Image(
            painter = painterResource(id = idImage),
            contentDescription = imageDescription,
            modifier = Modifier
                .height(150.dp)
                .clip(RoundedCornerShape(20.dp)),
        )

    }
}
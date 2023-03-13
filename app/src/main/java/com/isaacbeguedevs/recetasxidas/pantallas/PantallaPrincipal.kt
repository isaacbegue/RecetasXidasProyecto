package com.isaacbeguedevs.recetasxidas.pantallas

import android.annotation.SuppressLint
import com.isaacbeguedevs.recetasxidas.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PantallaPrincipal() {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = {BarraSuperior()}
    ) {
        ContenidoPantallaPrincipal()
    }
}

@Preview
@Composable
fun ContenidoPantallaPrincipal(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        /*lazy column irá cargando los elementos conforme se vayan cargando
        * pero necesita trabajar con items*/
        item {
            Column() {
                Text(
                    text = "Recetas de hoy",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
            /*espagueti a la carbonara*/
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Image(
                    painter = painterResource(id = R.drawable.espagueti_a_la_carbonara),
                    contentDescription = "espagueti carbonara",
                    modifier = Modifier
                        .height(120.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                Text(text = "Espagueti a la carbonara", fontSize = 18.sp)
            }
            /*pollo al horno*/
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pollo_al_horno_con_patatas_y_cebolla),
                    contentDescription = "pollo al horno",
                    modifier = Modifier
                        .height(120.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                Text(text = "Pollo al horno con patatas y cebolla", fontSize = 18.sp)
            }
            /*tortilla de patatas rellena de jamón y queso*/
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tortilla_de_patatas_rellena_de_jamon_y_queso),
                    contentDescription = "tortilla de patatas",
                    modifier = Modifier
                        .height(120.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                Text(text = "Tortilla de patatas con jamón y queso", fontSize = 18.sp)
            }
        }
    }
}
package com.isaacbeguedevs.recetasxidas.pantallas

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.isaacbeguedevs.recetasxidas.base_de_datos.AppDatabase
import com.isaacbeguedevs.recetasxidas.base_de_datos.Receta


@Composable
fun PantallaReceta(
    navController: NavController,
    context: Context,
    varGlobales: MutableMap<String,Any>,
) {
    val idReceta: Int = varGlobales["idReceta"] as Int
    val db = AppDatabase.getInstance(context)
    val receta: Receta? = db.recetaDao.getRecetaById(idReceta)
    val autor: String = db.userDao.getUserById(receta?.autorId ?: 0)?.user_name ?: ""
    val idImage: Int = receta?.ruta_imagen ?: 2130968578
    val imageDescription = receta?.titulo ?: ""
    val tituloReceta: String = receta?.titulo ?: ""
    val contenidoReceta: String = receta?.texto_receta?:""

    LazyColumn(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxSize()
    ) {
        item {
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

            Text(text = "Autor: $autor", modifier = Modifier.padding(horizontal = 20.dp))

            Image(
                painter = painterResource(id = idImage),
                contentDescription = imageDescription,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            )

            Text(text = contenidoReceta, modifier = Modifier.padding(20.dp))
        }

    }
}
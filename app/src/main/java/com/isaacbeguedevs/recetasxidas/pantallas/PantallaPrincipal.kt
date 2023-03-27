@file:Suppress("UNUSED_ANONYMOUS_PARAMETER")

package com.isaacbeguedevs.recetasxidas.pantallas

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.isaacbeguedevs.recetasxidas.base_de_datos.AppDatabase
import com.isaacbeguedevs.recetasxidas.base_de_datos.Receta
import com.isaacbeguedevs.recetasxidas.elementos.CardsPantallaPrincipal


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PantallaPrincipal(navController: NavController, context: Context, varGlobales: MutableMap<String, Any>) {
    RecetasCards(navController, context, varGlobales)
}



// Crear un componente composable para listar los usuarios como componentes composable
@Composable
fun RecetasCards(navController: NavController, context: Context, varGlobales: MutableMap<String, Any>) {

    // Usar un LazyColumn para crear una lista vertical de elementos perezosos
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
        }

        /*Acá se debe consultar a la base de datos*/
        val db = AppDatabase.getInstance(context)
        val listadoRecetas: List<Receta> = db.recetaDao.getAll()
//        Text(db.userDao.getUserById(1)?.user_name ?: "sin nombre")
//        Text(text = db.recetaDao.getRecetaById(1)?.titulo ?: "no hay")

        items(listadoRecetas) {fila ->
            CardsPantallaPrincipal(
                idImage = fila.ruta_imagen,
                imageDescription = fila.titulo,
                tituloReceta = fila.titulo,
                idReceta = fila.id,
                varGlobales = varGlobales,
                navController = navController
            )
        }
    }

}


package com.isaacbeguedevs.recetasxidas.pantallas

import com.isaacbeguedevs.recetasxidas.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.isaacbeguedevs.recetasxidas.elementos.RecetaEnPantallaPrincial
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalContext
import com.isaacbeguedevs.recetasxidas.base_de_datos.AppDatabase
import com.isaacbeguedevs.recetasxidas.base_de_datos.User


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PantallaPrincipal(navController: NavController) {
    /*consulta a la base de datos*/
    UserList(navController)

}

// Crear un componente composable para mostrar los datos de un usuario
@Composable
fun UserItem(user: User) {
    // Puedes usar otros componentes composable como Text, Image, etc. para diseñar el aspecto del usuario
    Text(text = "${user.name} - ${user.email}")
}

// Crear un componente composable para listar los usuarios como componentes composable
@Composable
fun UserList(navController: NavController) {
    // Get an instance of the database and the DAO
    val db = AppDatabase.getInstance(LocalContext.current)
    val userDao = db.userDao

    // Definir una lista de usuarios
    val users: List<User> = userDao.getAllUsers()
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

            /*Acá se debe consultar a la base de datos*/

            /*espagueti a la carbonara*/
            RecetaEnPantallaPrincial(idImage = R.drawable.espagueti_a_la_carbonara,
                imageDescription = "espagueti a la carbonara",
                tituloReceta = "Espagueti a la carbonara",
                navController = navController
            )

            /*pollo al horno*/
            RecetaEnPantallaPrincial(idImage = R.drawable.pollo_al_horno_con_patatas_y_cebolla,
                imageDescription = "pollo al horno",
                tituloReceta = "Pollo al horno con patatas y cebolla",
                navController = navController
            )
            /*tortilla de patatas rellena de jamón y queso*/
            RecetaEnPantallaPrincial(idImage = R.drawable.tortilla_de_patatas_rellena_de_jamon_y_queso,
                imageDescription = "tortilla de patatas",
                tituloReceta = "Tortilla de patatas con jamón y queso",
                navController = navController
            )
        }
        // Usar el método items() para iterar sobre la lista de usuarios y mostrar cada uno en un UserItem
        items(users) { user ->
            UserItem(user)
        }
    }
}

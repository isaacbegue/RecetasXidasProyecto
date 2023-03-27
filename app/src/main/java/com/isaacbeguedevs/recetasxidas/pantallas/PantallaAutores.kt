package com.isaacbeguedevs.recetasxidas.pantallas


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.isaacbeguedevs.recetasxidas.base_de_datos.AppDatabase
import com.isaacbeguedevs.recetasxidas.base_de_datos.User

@Composable
fun PantallaAutores(navController: NavController) {

    // Get an instance of the database and the DAO
    val db = AppDatabase.getInstance(LocalContext.current)
    val userDao = db.userDao

    // Definir una lista de usuarios
    val users: List<User> = userDao.getAllUsers()

    // Crear un componente composable para mostrar los datos de un usuario
    @Composable
    fun UserItem(user: User) {
        // Puedes usar otros componentes composable como Text, Image, etc. para diseñar el aspecto del usuario
        Text(text = "${user.user_name} - ${user.user_email}")
    }

    LazyColumn (Modifier.padding(horizontal = 20.dp)) {
        item {
            Text(text = "Autores del blog registrados",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        }
        // Usar el método items() para iterar sobre la lista de usuarios y mostrar cada uno en un UserItem
        items(users) { user ->
            UserItem(user)
        }


    }
}


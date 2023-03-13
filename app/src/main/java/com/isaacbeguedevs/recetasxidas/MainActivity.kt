package com.isaacbeguedevs.recetasxidas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.isaacbeguedevs.recetasxidas.pantallas.*
import com.isaacbeguedevs.recetasxidas.ui.theme.RecetasXidasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecetasXidasTheme {
                Surface(color = MaterialTheme.colors.background){
                    DibujarPantalla()
                }
            }
        }
    }
}

/*función contenedora de toda la pantalla*/

@Preview
@Composable
fun DibujarPantalla() {
//    LoginScreen()
    PantallaPrincipal()
}


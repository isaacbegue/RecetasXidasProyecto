package com.isaacbeguedevs.recetasxidas.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.isaacbeguedevs.recetasxidas.navigation.RutasPantallas
import okhttp3.*
import okio.IOException
import org.json.JSONObject


@Composable
fun PantallaTipoDeCambio(navController: NavController) {

    val pantallaActual = navController.currentBackStackEntry?.destination?.route!!
    val rutaPantallaTC = RutasPantallas.PantallaTipoDeCambio.route

    val token = "b4d4412ec8e207c314c74e8d39a841c9615ffa236672115fc41b29cf3a741d26"
    var botonTCPulsado by remember { mutableStateOf(false) }
    var resultadoConsulta by remember { mutableStateOf("") }

    /*Consulta a la API de Banco de México*/
    LaunchedEffect(Unit) {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://www.banxico.org.mx/SieAPIRest/service/v1/series/SF43718/datos/oportuno?token=${token}")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // Manejar el error
                resultadoConsulta = "no se pudo hacer la consulta"
            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body?.string()
                // Procesar la respuesta JSON
                val jsonObject = JSONObject(json!!)
                val seriesArray = jsonObject.getJSONObject("bmx").getJSONArray("series")
                val seriesObject = seriesArray.getJSONObject(0)
                val datosArray = seriesObject.getJSONArray("datos")
                val datosObject = datosArray.getJSONObject(0)

                val fecha = datosObject.getString("fecha")
                val dato = datosObject.getString("dato")
                resultadoConsulta = "Fecha: $fecha\n\nTipo de cambio dólar a pesos: $dato"
            }
        })
    }



    Column(modifier = Modifier.padding(20.dp)) {
        Button(modifier = Modifier.fillMaxWidth(), onClick = { botonTCPulsado = true }) {
            Text("Consultar Tipo de Cambio")
        }

        if (botonTCPulsado) {
            Text(text = resultadoConsulta, modifier = Modifier.padding(vertical = 20.dp))
        }


    }
}



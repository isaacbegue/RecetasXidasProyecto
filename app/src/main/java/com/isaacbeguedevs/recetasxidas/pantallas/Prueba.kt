package com.isaacbeguedevs.recetasxidas.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isaacbeguedevs.recetasxidas.R

@Preview
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen() {
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf("") }
    
    Scaffold(
        backgroundColor = MaterialTheme.colors.background
    ) {
        /*topBar*/
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
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_menu_24),
                contentDescription = "menu hamburguesa",
                modifier = Modifier
                    .height(60.dp)
                    .padding(horizontal = 15.dp)
            )
        }
    }

}
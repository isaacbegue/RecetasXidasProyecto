package com.isaacbeguedevs.recetasxidas

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.isaacbeguedevs.recetasxidas.pantallas.PantallaAutores
import org.junit.Rule
import org.junit.Test

class PantallaAutoresTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun comprobarQueSeCarganAutores() {
        rule.setContent { PantallaAutores() }
        rule.onNodeWithText("Autores del blog registrados").assertExists()
        rule.onNodeWithTag("usuariosCargados").assertExists()
        rule.onNodeWithTag("1").assertExists()
    }
}
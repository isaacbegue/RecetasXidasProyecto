package com.isaacbeguedevs.recetasxidas

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.isaacbeguedevs.recetasxidas.pantallas.PantallaTipoDeCambio
import org.junit.Rule
import org.junit.Test

class PantallaTipoDeCambioTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun comprobarPantalla_TipoDeCambio() {
        rule.setContent { PantallaTipoDeCambio() }

        //hacer clic en el botón de consulta
        rule.onNodeWithTag("resultado consulta").assertDoesNotExist()
        rule.onNodeWithText("Consultar Tipo de Cambio").performClick()
        rule.onNodeWithTag("resultado consulta").assertExists()

    }
}
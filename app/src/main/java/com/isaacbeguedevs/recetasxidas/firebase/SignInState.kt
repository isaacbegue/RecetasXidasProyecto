package com.isaacbeguedevs.recetasxidas.firebase

data class SignInState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)

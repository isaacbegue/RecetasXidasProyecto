package com.isaacbeguedevs.recetasxidas.base_de_datos

import android.content.Context
import com.isaacbeguedevs.recetasxidas.R

fun insertarDatos(applicationContext: Context) {
    val db = AppDatabase.getInstance(applicationContext)
    val users = listOf(
        User(0, "Juan", "juan@gmail.com"),
        User(0, "Ana", "ana@gmail.com"),
        User(0, "Pedro", "pedro@gmail.com"),
        User(0, "Laura", "laura@gmail.com"),
        User(0, "Carlos", "carlos@gmail.com"),
        User(0, "Sofía", "sofia@gmail.com")
    )
    db.userDao.insertUsers(users)

    val espagueti =
        "Ingredientes:\n- 400 gramos de espagueti\n- 150 gramos de panceta o bacon\n- 3 yemas de huevo\n- 1 huevo entero\n- 100 gramos de queso pecorino rallado\n- Sal y pimienta negra al gusto\n\nPreparación:\n1. Cocina los espaguetis en agua con sal hasta que estén al dente.\n2. Mientras tanto, corta la panceta o el bacon en tiras pequeñas y fríe en una sartén hasta que estén dorados.\n3. En un recipiente aparte, mezcla las yemas de huevo con el huevo entero y el queso pecorino rallado hasta que estén bien combinados.\n4. Escurre los espaguetis y reserva un poco del agua de la cocción.\n5. Agrega los espaguetis a la sartén con la panceta o el bacon y mezcla bien.\n6. Agrega la mezcla de huevo y queso a la sartén y mezcla bien.\n7. Si la salsa está demasiado espesa, agrega un poco del agua de la cocción de los espaguetis para diluir.\n8. Sirve caliente con un poco de pimienta negra molida por encima."

    val pollo = """
Ingredientes:
- 1 pollo cortado a octavos
- 300 gr. de cebolla
- 400 gr. de patatas a rodajas grandes
- 60 ml. de aceite de oliva virgen extra
- 5 gr. de sal
- 5 gr. de pimienta negra
- 600 ml. de Caldo Casero de Pollo 100% Natural

Preparación:
1. Precalentar el horno a 195ºC.
2. Limpia y seca el pollo, luego salpiméntalo y úntalo en aceite de oliva y el zumo de limón.
3. Corta la cebolla en juliana gruesa y repártela en una bandeja de horno con aceite. Añade una cabeza de ajos partida por la mitad y hornea 15 minutos a 195ºC.
4. Corta las patatas a rodajas grandes y dispónlas encima de la cebolla. Coloca también el pollo con la parte de la piel hacia arriba.
5. Vierte el caldo de pollo y hornea durante 45 minutos a 195ºC.
6. Sirve caliente.
"""
    val recetaTortilla = """
Ingredientes:
- 4 patatas medianas
- 6 huevos
- 100 gramos de jamón serrano
- 100 gramos de queso rallado
- Aceite de oliva
- Sal

Preparación:
1. Pelar y cortar las patatas en rodajas finas.
2. En una sartén con aceite de oliva, freír las patatas hasta que estén doradas.
3. Batir los huevos en un bol y añadir las patatas, el jamón serrano y el queso rallado. Mezclar bien.
4. En una sartén con un poco de aceite de oliva, verter la mezcla y cocinar a fuego medio-bajo hasta que la tortilla esté dorada por un lado.
5. Dar la vuelta a la tortilla y cocinar por el otro lado hasta que esté dorada.
6. Servir caliente.
"""


    val recetas = listOf(
        Receta(0, "Espagueti a la carbonara", R.drawable.espagueti_a_la_carbonara, espagueti,1),
        Receta(0,"Pollo al horno con patatas y cebolla", R.drawable.pollo_al_horno_con_patatas_y_cebolla,pollo,3),
        Receta(0,"Tortilla de patatas con jamón y queso",R.drawable.tortilla_de_patatas_rellena_de_jamon_y_queso,recetaTortilla,2)
    )

    db.recetaDao.insertRecetas(recetas = recetas)
}
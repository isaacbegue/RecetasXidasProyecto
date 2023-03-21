package com.isaacbeguedevs.recetasxidas

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.core.app.NotificationCompat
import com.isaacbeguedevs.recetasxidas.base_de_datos.AppDatabase
import com.isaacbeguedevs.recetasxidas.base_de_datos.User
import com.isaacbeguedevs.recetasxidas.navigation.Navigation
import com.isaacbeguedevs.recetasxidas.ui.theme.RecetasXidasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecetasXidasTheme {
                Surface(color = MaterialTheme.colors.background){
                    Navigation()
                }
            }
        }


        // Create a notification channel if needed (for Android 8.0 or higher)
        createNotificationChannel()
        // Show a simple notification when the app is opened
        showNotification()
    }




    /*notificaciones*/
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Example Channel"
            val descriptionText = "This is an example channel for notifications"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("example_channel", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification() {
        val builder = NotificationCompat.Builder(this, "example_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("La aplicación está en uso")
            .setContentText("RecetasXidas está corriendo correctamente...")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Show the notification with an ID of 1
        notificationManager.notify(1, builder.build())
    }

//        /*inserción de datos*/
//        private fun insertarDatos() {
//            val db = AppDatabase.getInstance(applicationContext)
//            val users = listOf(
//                User(0, "Juan", "juan@gmail.com"),
//                User(0, "Ana", "ana@gmail.com"),
//                User(0, "Pedro", "pedro@gmail.com"),
//                User(0, "Laura", "laura@gmail.com"),
//                User(0, "Carlos", "carlos@gmail.com"),
//                User(0, "Sofía", "sofia@gmail.com")
//            )
//
//            db.userDao.insertUsers(users)
//        }

}
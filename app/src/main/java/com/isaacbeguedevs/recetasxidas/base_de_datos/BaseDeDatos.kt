package com.isaacbeguedevs.recetasxidas.base_de_datos

import android.content.Context
import androidx.room.*

/*base de datos*/

/*tabla Usuarios*/
@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "user_id") var user_id: Int,
    @ColumnInfo(name = "user_name") var user_name: String,
    @ColumnInfo(name = "user_email") var user_email: String
)
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<User>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: User)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUsers(users: List<User>)

    @Delete
    fun deleteUser(user: User)

    @Delete
    fun deleteUsers(users: List<User>)

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE user_id = :id")
    fun getUserById(id: Int): User?

}

/*tabla recetas*/
@Entity(tableName = "recetas",
    foreignKeys = [ForeignKey(entity = User::class,
        parentColumns = ["user_id"],
        childColumns = ["autor_id"])])
data class Receta(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "titulo") val titulo: String,
    @ColumnInfo(name = "ruta_imagen") val ruta_imagen: Int,
    @ColumnInfo(name = "texto_receta") val texto_receta: String,
    @ColumnInfo(name = "autor_id") val autorId: Int
)

@Dao
interface RecetaDao {
    @Query("SELECT * FROM recetas")
    fun getAll(): List<Receta>

    @Query("SELECT * FROM recetas WHERE id = :id_receta")
    fun getRecetaById(id_receta: Int): Receta?

    @Insert
    fun insertRecetas(recetas: List<Receta>)

    @Delete
    fun delete(receta: Receta)
}

    @Database(entities = [User::class, Receta::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao
    abstract val recetaDao: RecetaDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "recetasxidas-database").allowMainThreadQueries().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

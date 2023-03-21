package com.isaacbeguedevs.recetasxidas.base_de_datos

import android.content.Context
import androidx.room.*

/*base de datos*/
@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "email") var email: String
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

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUserById(id: Int): User

}

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao

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

import android.content.Context // Asegúrate de que esta línea esté incluida
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Locker::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun lockerDao(): LockerDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "locker_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

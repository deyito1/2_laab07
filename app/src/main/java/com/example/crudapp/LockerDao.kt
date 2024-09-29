import androidx.lifecycle.LiveData // Asegúrate de que esta línea esté incluida
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LockerDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(locker: Locker)

    @Query("SELECT * FROM locker_table ORDER BY id ASC")
    fun getAllLockers(): LiveData<List<Locker>>

    @Delete
    suspend fun delete(locker: Locker)
}

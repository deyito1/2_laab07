import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locker_table")
data class Locker(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val lockerNumber: String,
    val isAvailable: Boolean
)

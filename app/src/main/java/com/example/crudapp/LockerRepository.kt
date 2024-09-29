import androidx.lifecycle.LiveData

class LockerRepository(private val lockerDao: LockerDao) {
    val allLockers: LiveData<List<Locker>> = lockerDao.getAllLockers()

    suspend fun insert(locker: Locker) {
        lockerDao.insert(locker)
    }

    suspend fun delete(locker: Locker) {
        lockerDao.delete(locker)
    }
}

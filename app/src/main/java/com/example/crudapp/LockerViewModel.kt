import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData

class LockerViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: LockerRepository
    val allLockers: LiveData<List<Locker>>

    init {
        val lockerDao = AppDatabase.getDatabase(application).lockerDao()
        repository = LockerRepository(lockerDao)
        allLockers = repository.allLockers
    }

    fun insert(locker: Locker) = viewModelScope.launch {
        repository.insert(locker)
    }

    fun delete(locker: Locker) = viewModelScope.launch {
        repository.delete(locker)
    }
}

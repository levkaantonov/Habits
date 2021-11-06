package levkaantonov.com.study.habits.screens.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import levkaantonov.com.study.habits.db.repository.DatabaseRepository
import levkaantonov.com.study.habits.di.HabitsRepository
import levkaantonov.com.study.habits.models.Habit
import javax.inject.Inject

@HiltViewModel
class AddEditFragmentViewModel @Inject constructor(
    @HabitsRepository private val repository: DatabaseRepository
) : ViewModel() {
    fun createHabit(habit: Habit) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.create(habit)
        }
    }

    fun updateHabit(habit: Habit) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(habit)
        }
    }
}
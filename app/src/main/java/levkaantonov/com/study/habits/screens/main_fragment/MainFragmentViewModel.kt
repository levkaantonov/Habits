package levkaantonov.com.study.habits.screens.main_fragment

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import levkaantonov.com.study.habits.db.repository.DatabaseRepository
import levkaantonov.com.study.habits.di.HabitsRepository
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    @HabitsRepository private val repository: DatabaseRepository
) : ViewModel() {
    val allHabits = repository.allHabits
}
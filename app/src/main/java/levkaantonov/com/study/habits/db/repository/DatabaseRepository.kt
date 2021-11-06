package levkaantonov.com.study.habits.db.repository

import androidx.lifecycle.LiveData
import levkaantonov.com.study.habits.models.Habit

interface DatabaseRepository {
    val allHabits : LiveData<List<Habit>>
    suspend fun create(habit: Habit)
    suspend fun update(habit: Habit)
    suspend fun delete(id: Int)
    suspend fun retrieve(id: Int): Habit
}
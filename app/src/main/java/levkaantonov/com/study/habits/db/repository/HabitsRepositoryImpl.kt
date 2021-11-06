package levkaantonov.com.study.habits.db.repository

import androidx.lifecycle.LiveData
import levkaantonov.com.study.habits.db.dao.HabitDao
import levkaantonov.com.study.habits.models.Habit
import javax.inject.Inject

class HabitsRepositoryImpl @Inject constructor(private val dao: HabitDao) : DatabaseRepository {
    override val allHabits: LiveData<List<Habit>>
        get() = dao.getAllHabits()

    override suspend fun create(habit: Habit) {
        dao.create(habit)
    }

    override suspend fun update(habit: Habit) {
        dao.update(habit)
    }

    override suspend fun delete(id: Int) {
        delete(id)
    }

    override suspend fun retrieve(id: Int): Habit {
        return dao.retrieve(id)
    }
}
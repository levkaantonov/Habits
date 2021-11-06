package levkaantonov.com.study.habits.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import levkaantonov.com.study.habits.models.Habit

@Dao
interface HabitDao {
    @Query("select * from habits order by createdDate desc")
    fun getAllHabits(): LiveData<List<Habit>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(habit: Habit)

    @Query("select * from habits where id = :id")
    suspend fun retrieve(id: Int): Habit

    @Update
    suspend fun update(habit: Habit)

    @Delete
    suspend fun delete(habit: Habit)
}
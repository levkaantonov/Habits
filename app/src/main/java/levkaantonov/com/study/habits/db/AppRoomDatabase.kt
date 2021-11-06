package levkaantonov.com.study.habits.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import levkaantonov.com.study.habits.db.dao.HabitDao
import levkaantonov.com.study.habits.models.Habit
import javax.inject.Singleton

@Singleton
@Database(entities = [Habit::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao

    companion object{
        const val DATABASE_NAME = "habits_database"
    }
}
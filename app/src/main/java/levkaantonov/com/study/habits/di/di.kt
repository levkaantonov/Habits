package levkaantonov.com.study.habits.di

import android.app.Application
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import levkaantonov.com.study.habits.db.repository.HabitsRepositoryImpl
import dagger.hilt.components.SingletonComponent
import levkaantonov.com.study.habits.db.AppRoomDatabase
import levkaantonov.com.study.habits.db.dao.HabitDao
import levkaantonov.com.study.habits.db.repository.DatabaseRepository
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {
    @HabitsRepository
    @Binds
    @Singleton
    abstract fun bindHabitRepository(habitsRepository: HabitsRepositoryImpl): DatabaseRepository

}

@Module
@InstallIn(SingletonComponent::class)
object Database{

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppRoomDatabase =
        Room.databaseBuilder(
            app,
            AppRoomDatabase::class.java,
            AppRoomDatabase.DATABASE_NAME
        ).build()

    @Provides
    fun provideHabitDao(database: AppRoomDatabase): HabitDao =
        database.habitDao()
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HabitsRepository
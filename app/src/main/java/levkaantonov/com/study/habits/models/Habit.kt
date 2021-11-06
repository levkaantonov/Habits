package levkaantonov.com.study.habits.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "habits")
@Parcelize
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val createdDate: Long,
    val description: String,
    val type: Int,
    val priority: Int,
    val period: String,
    val color: Int) : Parcelable
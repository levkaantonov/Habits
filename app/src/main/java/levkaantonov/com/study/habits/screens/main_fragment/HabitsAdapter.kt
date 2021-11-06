package levkaantonov.com.study.habits.screens.main_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import levkaantonov.com.study.habits.databinding.ItemHabitBinding
import levkaantonov.com.study.habits.models.Habit

class HabitsAdapter : ListAdapter<Habit, RecyclerView.ViewHolder>(HabitDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HabitViewHolder(ItemHabitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val habit = getItem(position)
        (holder as HabitViewHolder).bind(habit)
    }

    class HabitViewHolder(
         private val binding: ItemHabitBinding
     ) : RecyclerView.ViewHolder(binding.root){
         fun bind(item: Habit){
            binding.habitDescription.text = item.description
             binding.habitName.text = item.name
             binding.habitPeriod.text = item.period
             binding.habitPriority.text = item.priority.toString()
             binding.habitType.text = item.type.toString()
         }
     }
}

private class HabitDiffCallback : DiffUtil.ItemCallback<Habit>(){
    override fun areItemsTheSame(oldItem: Habit, newItem: Habit): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Habit, newItem: Habit): Boolean {
        return oldItem == newItem
    }

}
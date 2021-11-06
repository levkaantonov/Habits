package levkaantonov.com.study.habits.screens.edit

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import levkaantonov.com.study.habits.R
import levkaantonov.com.study.habits.databinding.FragmentAddEditBinding
import levkaantonov.com.study.habits.models.Habit
import java.util.*

class AddEditFragment : Fragment() {
    private var _binding: FragmentAddEditBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddEditFragmentViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        initialize()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initialize() {
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edit_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_save -> {
                val name = binding.habitName.text.toString()
                val createdDate = System.currentTimeMillis()
                val description = binding.habitDescription.text.toString()
                val type = binding.radioGroup.checkedRadioButtonId
                val priority = binding.habitPriority.selectedItemPosition
                val period = binding.habitPeriodicity.text.toString()
                val color = 0

                var habit = Habit(
                    name = name,
                    createdDate = createdDate,
                    description = description,
                    type = type,
                    priority = priority,
                    period = period,
                    color = color
                )

                saveOrUpdate(habit)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveOrUpdate(habit: Habit) {
        viewModel.createHabit(habit)
    }
}

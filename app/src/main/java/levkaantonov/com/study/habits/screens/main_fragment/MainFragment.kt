package levkaantonov.com.study.habits.screens.main_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import levkaantonov.com.study.habits.databinding.FragmentMainBinding
import levkaantonov.com.study.habits.models.Habit

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainFragmentViewModel by viewModels()
    private lateinit var adapter: HabitsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    private fun initialize() {
        adapter = HabitsAdapter()
    }

    private fun subscribeUi(adapter: HabitsAdapter) {
        viewModel.allHabits.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

    private fun navigateToAdd(){
        val action = MainFragmentDirections.actionMainFragmentToAddEditFragment(null)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.addNewHabit.setOnClickListener {
            navigateToAdd()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.recyclerView.adapter = null
        _binding = null
    }
}
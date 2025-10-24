package com.app.apptodo.apptodo.addtask

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.app.apptodo.AppTodoRepositoryImplementation
import com.app.apptodo.R
import com.app.apptodo.apptodo.Task
import com.app.apptodo.apptodo.TaskAdapter
import com.app.apptodo.apptodo.list.TodoListFragment
import com.app.apptodo.databinding.FragmentInputBinding

class TodoAddTaskFragment: Fragment(), TodoAddTaskContract.View {

    private lateinit var adaptor : TaskAdapter
    private var _binding : FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInputBinding.inflate(
            layoutInflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val presenter = TodoAddTaskPresenter(this, AppTodoRepositoryImplementation())

        adaptor = TaskAdapter(requireContext(), mutableListOf())

        with (binding) {
            btnButton.setOnClickListener {

                val task = inputText.text.toString()
                presenter.onSaveTaskClicked(1, task)

                Toast.makeText(context,"Task created!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun navigateToListFragment() {
        parentFragmentManager.popBackStack()
    }
}
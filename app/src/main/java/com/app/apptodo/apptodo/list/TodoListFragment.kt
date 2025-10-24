package com.app.apptodo.apptodo.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.apptodo.AppTodoRepositoryImplementation
import com.app.apptodo.apptodo.TaskAdapter
import com.app.apptodo.apptodo.Task
import com.app.apptodo.databinding.FragmentTaskBinding
import com.app.apptodo.R
import com.app.apptodo.apptodo.addtask.TodoAddTaskFragment

class TodoListFragment: Fragment(), TodoListContract.View {
    private lateinit var presenter: TodoListContract.Presenter
    private lateinit var adaptor: TaskAdapter
    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         _binding = FragmentTaskBinding.inflate(
            layoutInflater,
            container,
            false
        )

        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adaptor = TaskAdapter(requireContext(), mutableListOf())
        val recyclerView = binding.recyclerList
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adaptor

        presenter = TodoListPresenter(this, AppTodoRepositoryImplementation())
        presenter.loadTasks()

        with(binding) {
            btnTask.setOnClickListener {
                presenter.onAddTaskButtonClicked()
            }
        }

    }

    override fun returnTasks(tasks: MutableList<Task>) {
        adaptor.updateData(tasks)
        Log.i("returnTasks", "$tasks")
    }

    override fun navigateToAddTaskFragment() {
        parentFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            TodoAddTaskFragment()
        ).addToBackStack(null).commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
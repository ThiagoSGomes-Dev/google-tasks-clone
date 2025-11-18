package com.app.apptodo.apptodo.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.apptodo.apptodo.addtask.TodoAddTaskFragment
import com.app.apptodo.data.Task
import com.app.apptodo.databinding.FragmentTaskBinding

class TodoListFragment: Fragment(), TodoListContract.View {
    private val presenter: TodoListPresenter by lazy {
        TodoListPresenter(this, ListRepositoryImplementation())
    }
    private lateinit var adapter: TodoListAdapter
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

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        presenter.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
        presenter.loadTasks()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TodoListAdapter(
            onClick = presenter::onTaskClicked,
            onLongClick = presenter::onTaskLongClicked
        )

        with(binding) {

            recyclerList.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@TodoListFragment.adapter
            }

            btnTask.setOnClickListener {
                presenter.onAddTaskButtonClicked()
            }
        }
    }

    override fun showTaskRemoved(task: Task) {
        adapter.removeTask(task)
    }

    override fun showTaskUpDate(task: Task) {
        adapter.updateTask(task)
    }

    override fun returnTasks(tasks: List<Task>) {
        adapter.setTasks(tasks)
    }

    override fun navigateToAddTaskFragment() {
        TodoAddTaskFragment().show(parentFragmentManager, "add_task_sheet")
    }
}

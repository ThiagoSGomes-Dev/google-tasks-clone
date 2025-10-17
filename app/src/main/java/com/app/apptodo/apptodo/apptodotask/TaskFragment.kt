package com.app.apptodo.apptodo.apptodotask

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.apptodo.AppTodoRepositoryImplementation
import com.app.apptodo.R
import com.app.apptodo.apptodo.AppTodoAdaptor
import com.app.apptodo.apptodo.apptodoinput.InputFragment
import com.app.apptodo.apptodo.Task
import com.app.apptodo.databinding.FragmentTaskBinding

class TaskFragment: Fragment(), TaskContract.View {
    private lateinit var presenter: TaskContract.Presenter
    private lateinit var adaptor: AppTodoAdaptor
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

        adaptor = AppTodoAdaptor(requireContext(), mutableListOf())
        val recyclerView = binding.recyclerList
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adaptor

        presenter = TaskPresenter(this, AppTodoRepositoryImplementation())
        presenter.loadTasks()

        with(binding) {
            btnTask.setOnClickListener {
                parentFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    InputFragment()
                ).commit()
            }
        }

    }

    override fun returnTasks(tasks: MutableList<Task>) {
        adaptor.updateData(tasks)
        Log.i("returnTasks", "$tasks")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
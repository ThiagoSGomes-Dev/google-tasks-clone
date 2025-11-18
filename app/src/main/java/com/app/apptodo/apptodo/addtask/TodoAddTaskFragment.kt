package com.app.apptodo.apptodo.addtask

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.app.apptodo.data.Task
import com.app.apptodo.databinding.FragmentInputBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TodoAddTaskFragment: BottomSheetDialogFragment(), TodoAddTaskContract.View {

    private val presenter: TodoAddTaskContract.Presenter by lazy {
        TodoAddTaskPresenter(this, AddTaskRepositoryImplementation())
    }
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

        with (binding) {
            btnButton.setOnClickListener {
                val title = inputText.text.toString()
                val task = Task(name = title)
                dismiss()
                presenter.onAddTaskClicked(task)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        presenter.onDestroyView()
    }
}
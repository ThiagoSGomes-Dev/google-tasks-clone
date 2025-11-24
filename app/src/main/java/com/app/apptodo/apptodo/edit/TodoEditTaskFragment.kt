package com.app.apptodo.apptodo.edit

import android.app.ActivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.app.apptodo.data.Task
import com.app.apptodo.databinding.FragmentEditBinding

class TodoEditTaskFragment: Fragment(), TodoEditTaskContract.View {
    private val taskId: Int get() = requireArguments().getInt(ARG_ID)
    private var onTaskUpDate: ((Task) -> Unit)? = null
    private val presenter: TodoEditTaskPresenter by lazy {
        TodoEditTaskPresenter(this, TodoEditTaskRepositoryImplementation())
    }
    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditBinding.inflate(
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
        presenter.loadTask(taskId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun showBindTask(task: Task) {
        binding.apply {
            textInputEditText.setText(task.name)
            textInputEditTextDesc.setText(task.description)

            btnBackUpDate.setOnClickListener {
                val updateTask = task.copy(
                    name = textInputEditText.text.toString(),
                    description = textInputEditTextDesc.text.toString()
                )
                presenter.upDateTask(updateTask)
            }
        }
    }

    // apply { name = textInputEditText.text.toString(), description = textInputEditTextDesc.text.toString() }

    override fun closeFragment(upDateTask: Task) {
        onTaskUpDated(upDateTask)
        parentFragmentManager.popBackStack()
    }

    override fun onTaskUpDated(task: Task) {
        onTaskUpDate?.invoke(task)
    }

    companion object {
        private const val ARG_ID = "task_id"
        fun newInstance(
            taskId: Int,
            onTaskUpDated: (Task) -> Unit
        ) = TodoEditTaskFragment().apply {
            val fragment = TodoEditTaskFragment()
            fragment.arguments = bundleOf(
                ARG_ID to taskId
            )
            fragment.onTaskUpDate = onTaskUpDated

            return fragment
        }
    }

}
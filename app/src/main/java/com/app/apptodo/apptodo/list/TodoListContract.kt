package com.app.apptodo.apptodo.list

import com.app.apptodo.apptodo.Task

interface TodoListContract {
    interface View {
        fun returnTasks(tasks: MutableList<Task>)
        fun navigateToAddTaskFragment()
    }

    interface Presenter {
        fun onAddTaskButtonClicked()
        fun loadTasks()
        fun addTask(id: Long, task: String)
    }
}
package com.app.apptodo.apptodo.list

import com.app.apptodo.data.Task
import io.reactivex.rxjava3.core.Observable

interface TodoListContract {
    interface View {
        fun showTaskRemoved(task: Task)
        fun returnTasks(tasks: List<Task>)
        fun navigateToAddTaskFragment()
    }

    interface Presenter {
        fun onAddTaskButtonClicked()
        fun loadTasks()
        fun removeTaskLongClick(task: Task): Boolean

        fun onDestroy()
    }
}
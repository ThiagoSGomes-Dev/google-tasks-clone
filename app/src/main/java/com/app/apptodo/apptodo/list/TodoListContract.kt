package com.app.apptodo.apptodo.list

import com.app.apptodo.data.Task
import io.reactivex.rxjava3.core.Observable

interface TodoListContract {
    interface View {
        fun showIsFavoriteUpdate(task: Task)
        fun showTaskUpDate(task: Task)
        fun showTaskRemoved(task: Task)
        fun returnTasks(tasks: List<Task>)
        fun navigateToAddTaskFragment()
    }

    interface Presenter {
        fun toggleFavorite(task: Task)
        fun loadTasks()
        fun onAddTaskButtonClicked()
        fun onTaskClicked(task: Task)
        fun onTaskLongClicked(task: Task)
        fun onDestroyView()
    }
}
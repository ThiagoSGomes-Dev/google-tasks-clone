package com.app.apptodo.apptodo.apptodotask

import com.app.apptodo.AppTodoRepository
import com.app.apptodo.apptodo.Task

class TaskPresenter(
    private val view: TaskContract.View,
    private val repository: AppTodoRepository
): TaskContract.Presenter {
    override fun loadTasks() {
        repository.getList()
        view.returnTasks(repository.getList())
    }

    override fun addTask(task: Task) {
        repository.addTask(task)
        loadTasks()
    }

}
package com.app.apptodo.apptodo.list

import com.app.apptodo.AppTodoRepository

class TodoListPresenter(
    private val view: TodoListContract.View?,
    private val repository: AppTodoRepository
): TodoListContract.Presenter {
    override fun onAddTaskButtonClicked() {
        view?.navigateToAddTaskFragment()
    }

    override fun loadTasks() {
        repository.readTask()
        view?.returnTasks(repository.readTask())
    }

    override fun addTask(id: Long, task: String) {
        repository.addTask(id, task)
        loadTasks()
    }

}
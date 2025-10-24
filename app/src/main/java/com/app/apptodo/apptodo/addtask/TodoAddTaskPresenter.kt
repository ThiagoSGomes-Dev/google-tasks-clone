package com.app.apptodo.apptodo.addtask

import com.app.apptodo.AppTodoRepository

class TodoAddTaskPresenter(
    private val view: TodoAddTaskContract.View?,
    private val repository: AppTodoRepository
): TodoAddTaskContract.Presenter {
    override fun onSaveTaskClicked(id: Long, task: String) {
        repository.addTask(id = id, name = task)
        view?.navigateToListFragment()
    }
}
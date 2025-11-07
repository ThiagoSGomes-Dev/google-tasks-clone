package com.app.apptodo.apptodo.addtask

import com.app.apptodo.data.Task
import com.app.apptodo.data.AppTodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoAddTaskPresenter(
    private val view: TodoAddTaskContract.View?,
    private val repository: AppTodoRepository,
    private val scape: CoroutineScope = CoroutineScope(Dispatchers.IO)
): TodoAddTaskContract.Presenter {
    override fun onAddTaskClicked( task: Task) {
        scape.launch {
            repository.addTask( task)
            view?.showAddTask(task)
            view?.navigateToListFragment()
        }
    }
}
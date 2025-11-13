package com.app.apptodo.apptodo.list

import com.app.apptodo.data.AppTodoDatabase
import com.app.apptodo.data.Data
import com.app.apptodo.data.Task
import io.reactivex.rxjava3.core.Single

interface ListRepository {
    fun readTask(): Single<List<Task>>
    fun removeTask(task: Task): Boolean
}

class ListRepositoryImplementation(
    private val data: MutableList<Task> = Data.list
): ListRepository {

    private val dataBase = AppTodoDatabase.getInstance()

    override fun removeTask(task: Task): Boolean {
        val index = data.indexOfFirst{ taskId -> taskId.id == task.id }
        return if (index != -1) {
            data.removeAt(index)
            true
        } else false
    }

    override fun readTask(): Single<List<Task>> {
        return dataBase.taskDao().getAll()
    }
}
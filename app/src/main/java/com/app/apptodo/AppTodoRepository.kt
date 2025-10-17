package com.app.apptodo

import com.app.apptodo.apptodo.Task
import java.io.Serial


interface AppTodoRepository {
    fun addTask(id: Long, name: String)
    fun readTask(): MutableList<Task>
    fun upDateTask(id: Long, newName: String): Boolean
    fun isCompleted(id: Long): Boolean
    fun removeTask(id: Long): Boolean
    fun removeIsCompeted(id: Long): Boolean
}

class AppTodoRepositoryImplementation: AppTodoRepository {
    val data: MutableList<Task> = Data.list
    var nextId: Long = 1


    override fun addTask(id: Long, name: String) {
        data.add(Task(nextId++, name))
    }

    override fun readTask(): MutableList<Task> {
        return data
    }

    override fun upDateTask(id: Long, newName: String): Boolean =
        data.find { taskId -> taskId.id == id }?.let {
            it.name = newName
            true
        } ?: false

    override fun isCompleted(id: Long): Boolean =
        data.find { taskId -> taskId.id == id }?.let {
            it.isCompeted = true
            true
        } ?: false

    override fun removeTask(id: Long): Boolean =
        data.removeIf { taskId -> taskId.id == id }

    override fun removeIsCompeted(id: Long): Boolean =
        data.find { taskId -> taskId.id == id && taskId.isCompeted }?.let {
            data.remove( it)
            true
        } ?: false
}

data object Data {
    var list = mutableListOf<Task>()
}
package com.app.apptodo.apptodo.addtask

import com.app.apptodo.data.AppTodoDatabase
import com.app.apptodo.data.Task
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

interface AddTaskRepository {
    fun addTask(task: Task): Completable
}

class AddTaskRepositoryImplementation: AddTaskRepository {
    private val dataBase = AppTodoDatabase.getInstance()

    override fun addTask(task: Task): Completable {
       return dataBase.taskDao().insert(task)
            .subscribeOn(Schedulers.io())
    }

}
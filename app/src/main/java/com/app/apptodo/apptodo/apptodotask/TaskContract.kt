package com.app.apptodo.apptodo.apptodotask

import com.app.apptodo.apptodo.Task

interface TaskContract {
    interface View {
        fun returnTasks(tasks: MutableList<Task>)
    }

    interface Presenter {
        fun loadTasks()
        fun addTask(task: Task)
    }
}
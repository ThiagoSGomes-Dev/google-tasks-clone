package com.app.apptodo.apptodo.addtask

interface TodoAddTaskContract {
    interface View {
        fun navigateToListFragment()
    }

    interface Presenter {
        fun onSaveTaskClicked(id: Long, task: String)
    }
}
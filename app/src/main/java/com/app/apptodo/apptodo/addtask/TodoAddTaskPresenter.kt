package com.app.apptodo.apptodo.addtask

import com.app.apptodo.data.Task
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TodoAddTaskPresenter(
    private val view: TodoAddTaskContract.View?,
    private val repository: AddTaskRepository
): TodoAddTaskContract.Presenter {
    private val disposables = CompositeDisposable()

    override fun onAddTaskClicked( task: Task) {
        val disposable = repository.addTask(task)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ view?.showAddTask(task) })
        disposables.add(disposable)
        view?.navigateToListFragment()
    }

    override fun onDestroy() {
        disposables.clear()
    }
}
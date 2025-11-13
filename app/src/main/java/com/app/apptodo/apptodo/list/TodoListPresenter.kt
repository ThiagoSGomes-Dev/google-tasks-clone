package com.app.apptodo.apptodo.list

import com.app.apptodo.data.Task
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TodoListPresenter(
    private val view: TodoListContract.View?,
    private val repository: ListRepository
): TodoListContract.Presenter {

    private val disposables = CompositeDisposable()
    override fun removeTaskLongClick(task: Task): Boolean {
        repository.removeTask(task)
        view?.showTaskRemoved(task)
        return true
    }

    override fun onAddTaskButtonClicked() {
        view?.navigateToAddTaskFragment()
    }

    override fun loadTasks() {
        val disposable = repository.readTask()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({view?.returnTasks(it)})
        disposables.add(disposable)
    }

    override fun onDestroy() {
        disposables.clear()
    }
}
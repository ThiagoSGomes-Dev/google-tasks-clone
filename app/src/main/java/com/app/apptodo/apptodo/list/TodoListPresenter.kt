package com.app.apptodo.apptodo.list

import com.app.apptodo.data.Task
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TodoListPresenter(
    private val view: TodoListContract.View?,
    private val repository: ListRepository
): TodoListContract.Presenter {

    private val disposable = CompositeDisposable()

    override fun onClickedEditView(taskId: Int) {
            view?.navigationToEdit(taskId)
    }

    override fun onTaskLongClicked(task: Task) {
        repository.removeTask(task)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {view?.showTaskRemoved(task)}
            .also { disposable.add(disposable) }
    }

    override fun toggleFavorite(task: Task) {
        repository.upDateTask(task.apply { isFavorite = !isFavorite })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { view?.showIsFavoriteUpdate(task) }
            .also { disposable.add(disposable) }
    }

    override fun onTaskClicked(task: Task) {
        repository.upDateTask(task.apply { isCompleted = !isCompleted })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { view?.showTaskUpDate(task) }
            .also { disposable.add(disposable) }
    }

    override fun onAddTaskButtonClicked() {
        view?.navigateToAddTaskFragment()
    }

    override fun loadTasks() {
        repository.getTasks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { tasks ->
                if (tasks.isEmpty()) {
                    view?.bindEmptyState()
               } else {
                    view?.returnTasks(tasks)
                }
            }
            .also { disposable.add(disposable) }
    }

    override fun onDestroyView() {
        disposable.clear()
    }
}
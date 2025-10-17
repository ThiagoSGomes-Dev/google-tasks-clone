package com.app.apptodo.dda

data class TaskTest(
    val id: Int,
    var name: String,
    var description: String?,
    var checkTask: Boolean = false
)

class Todo {

    private val tasks: MutableList<TaskTest> = mutableListOf()
    private var nextId = 1

    fun addTask(name: String, description: String) {
        tasks.add(TaskTest(nextId++, name, description))
    }

    fun seeTask(): List<TaskTest> {
        return tasks.toList()
    }

    fun isCompleted(id: Int): Boolean =
        tasks.find { taskId -> taskId.id == id }?.let {
            it.checkTask = true
            true
        } ?: false

    fun upDateTask(id: Int, UpDatename: String): Boolean =
        tasks.find { taskId -> taskId.id == id }?.let {
            it.name = UpDatename
            true
        } ?: false

}

fun main() {
    val todo = Todo()

    todo.addTask("Correr", "Uma vez por semana")
    todo.addTask("Estudar Kotlin", "Duas vezes por semana")
    todo.addTask("Estudar Android", "De segunda à sexta")
    todo.addTask("Correr", "Finais de semana")


    println("Lista : ${todo.seeTask().map { it.name }}")

    todo.isCompleted(2)
    println("Item concluído: ${todo.seeTask().first{ it.id == 2 }}")
    println("Item concluído: ${todo.seeTask().first{ it.id == 1 }}")

    todo.upDateTask(4, "Fazer barra fixa")
    println("Lista: ${todo.seeTask().map { it.name }}")
}
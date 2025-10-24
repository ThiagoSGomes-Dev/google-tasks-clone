package com.app.apptodo.apptodo

data class Task(
    val id: Long,
    var name: String,
    var description: String? = null,
    var isCompleted: Boolean = false,
    var isFavorite: Boolean = false,
)

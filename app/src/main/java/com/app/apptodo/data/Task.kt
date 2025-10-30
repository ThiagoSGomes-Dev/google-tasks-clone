package com.app.apptodo.data

data class Task(
    val id: Int = 1,
    var name: String,
    val description: String? = null,
    var isCompleted: Boolean = false,
    val isFavorite: Boolean = false,
)
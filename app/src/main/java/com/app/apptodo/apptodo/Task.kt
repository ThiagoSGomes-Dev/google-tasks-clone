package com.app.apptodo.apptodo

data class Task(
    val id: Long,
    var name: String,
    var description: String? = null,
    var isCompeted: Boolean = false,
    var isFavorite: Boolean = false,
)

package com.boshra.mvvm.model.domain.model

import com.boshra.mvvm.model.data.local.entites.TodoItem

data class Todo(
    val id: Int = 0,
    val title: String,
    val isDone: Boolean = false,
    val createdAt: Long
)

fun Todo.toEntity() = TodoItem(id, title, isDone, createdAt)
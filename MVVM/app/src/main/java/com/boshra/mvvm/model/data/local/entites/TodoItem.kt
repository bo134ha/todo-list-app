package com.boshra.mvvm.model.data.local.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.boshra.mvvm.model.domain.model.Todo

@Entity(tableName = "todo_table")
data class TodoItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val isDone: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
fun TodoItem.toDomain() = Todo(id, title, isDone, createdAt)

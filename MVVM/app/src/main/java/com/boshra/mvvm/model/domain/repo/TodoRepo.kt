package com.boshra.mvvm.model.domain.repo

import com.boshra.mvvm.model.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepo {
    fun getAllTasks(): Flow<List<Todo>>
    suspend fun insertTask(todo: Todo)
    suspend fun deleteTask(todo: Todo)
    suspend fun toggleTask(todo: Todo)

}
package com.boshra.mvvm.model.data.repo

import com.boshra.mvvm.model.data.local.dao.TodoDao
import com.boshra.mvvm.model.data.local.entites.toDomain
import com.boshra.mvvm.model.domain.model.Todo
import com.boshra.mvvm.model.domain.model.toEntity
import com.boshra.mvvm.model.domain.repo.TodoRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoRepositoryImpl(private val dao: TodoDao) : TodoRepo {

    override fun getAllTasks(): Flow<List<Todo>> {
        return dao.getAllTasks().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insertTask(todo: Todo) {
        dao.insertTask(todo.toEntity())
    }

    override suspend fun deleteTask(todo: Todo) {
        dao.deleteTask(todo.toEntity())
    }

    override suspend fun toggleTask(todo: Todo) {
        dao.updateTask(todo.toEntity())
    }
}
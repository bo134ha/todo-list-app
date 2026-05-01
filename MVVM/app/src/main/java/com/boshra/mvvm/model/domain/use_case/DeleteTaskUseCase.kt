package com.boshra.mvvm.model.domain.use_case

import com.boshra.mvvm.model.domain.model.Todo
import com.boshra.mvvm.model.domain.repo.TodoRepo

class DeleteTaskUseCase(private val repository: TodoRepo) {
    suspend operator fun invoke(todo: Todo) {
        repository.deleteTask(todo)
    }
}
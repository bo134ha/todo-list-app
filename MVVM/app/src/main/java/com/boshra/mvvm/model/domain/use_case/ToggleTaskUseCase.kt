package com.boshra.mvvm.model.domain.use_case

import com.boshra.mvvm.model.domain.model.Todo
import com.boshra.mvvm.model.domain.repo.TodoRepo

class ToggleTaskUseCase(private val repository: TodoRepo) {
    suspend operator fun invoke (todo: Todo) = repository.toggleTask(todo)
}
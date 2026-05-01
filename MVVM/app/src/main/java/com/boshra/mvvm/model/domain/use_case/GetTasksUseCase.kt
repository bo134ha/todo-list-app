package com.boshra.mvvm.model.domain.use_case

import com.boshra.mvvm.model.domain.repo.TodoRepo

class GetTasksUseCase(private val repository: TodoRepo) {
    operator fun invoke() = repository.getAllTasks()
}
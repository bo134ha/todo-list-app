package com.boshra.mvvm.model.domain.use_case

import com.boshra.mvvm.model.domain.model.Todo
import com.boshra.mvvm.model.domain.repo.TodoRepo

class AddTaskUseCase(private val repository: TodoRepo) {
    suspend operator fun invoke(title: String) {
        if (title.isNotBlank()) {
            repository.insertTask(Todo(title = title, createdAt = System.currentTimeMillis()))
        }
    }
}

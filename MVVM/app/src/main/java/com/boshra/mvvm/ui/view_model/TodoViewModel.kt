package com.boshra.mvvm.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boshra.mvvm.model.domain.model.Todo
import com.boshra.mvvm.model.domain.use_case.AddTaskUseCase
import com.boshra.mvvm.model.domain.use_case.DeleteTaskUseCase
import com.boshra.mvvm.model.domain.use_case.GetTasksUseCase
import com.boshra.mvvm.model.domain.use_case.ToggleTaskUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TodoViewModel(
    getTasksUseCase: GetTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val toggleTaskUseCase: ToggleTaskUseCase
) : ViewModel() {

    val tasks: StateFlow<List<Todo>> = getTasksUseCase().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList()
    )

    fun createTimerState(time: Long) = createTimer(time).stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000), 0L)

    private fun createTimer(time: Long): Flow<Long> = flow {
        while (true) {
            val currentTime = System.currentTimeMillis()
            val difference = currentTime - time

            emit(difference)
            delay(1000*60L)
        }
    }

    fun onAddTask(title: String) {
        viewModelScope.launch {
            addTaskUseCase(title)
        }
    }

    fun onDeleteTask(todo: Todo) {
        viewModelScope.launch {
            deleteTaskUseCase(todo)
        }
    }

    fun onToggleTask(todo: Todo) {
        viewModelScope.launch {
            toggleTaskUseCase(todo)
        }
    }

}
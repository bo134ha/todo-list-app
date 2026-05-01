package com.boshra.mvvm.ui.screens.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boshra.mvvm.model.domain.use_case.AddTaskUseCase
import com.boshra.mvvm.model.domain.use_case.DeleteTaskUseCase
import com.boshra.mvvm.model.domain.use_case.GetTasksUseCase
import com.boshra.mvvm.model.domain.use_case.ToggleTaskUseCase
import com.boshra.mvvm.ui.screens.TodoApp
import com.boshra.mvvm.ui.view_model.TodoViewModel

@Composable
fun Navigation(
    navHostController: NavHostController = rememberNavController(),
    getTasksUseCase: GetTasksUseCase,
    addTaskUseCase: AddTaskUseCase,
    deleteTaskUseCase: DeleteTaskUseCase,
    toggleTaskUseCase: ToggleTaskUseCase,
    modifier: Modifier
) {

    NavHost(navController = navHostController, "main") {

        composable(route = "main") {

            val todoViewModel: TodoViewModel = viewModel(factory = object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    @Suppress("UNCHECKED_CAST")
                    return TodoViewModel(
                        getTasksUseCase = getTasksUseCase,
                        addTaskUseCase = addTaskUseCase,
                        deleteTaskUseCase = deleteTaskUseCase,
                        toggleTaskUseCase = toggleTaskUseCase,
                    ) as T
                }
            })

            TodoApp(
                todoViewModel,
                modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
    }
}
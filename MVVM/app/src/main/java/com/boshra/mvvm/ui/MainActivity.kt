package com.boshra.mvvm.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import com.boshra.mvvm.model.data.local.database.TodoDatabase
import com.boshra.mvvm.model.data.repo.TodoRepositoryImpl
import com.boshra.mvvm.model.domain.use_case.AddTaskUseCase
import com.boshra.mvvm.model.domain.use_case.DeleteTaskUseCase
import com.boshra.mvvm.model.domain.use_case.GetTasksUseCase
import com.boshra.mvvm.model.domain.use_case.ToggleTaskUseCase
import com.boshra.mvvm.ui.screens.navigation.Navigation
import com.boshra.mvvm.ui.theme.MVVMTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val db = TodoDatabase.Companion.getDatabase(this)
            val repository = TodoRepositoryImpl(db.todoDao())

            val getTasksUseCase = GetTasksUseCase(repository)
            val addTaskUseCase = AddTaskUseCase(repository)
            val deleteTaskUseCase = DeleteTaskUseCase(repository)
            val toggleTaskUseCase = ToggleTaskUseCase(repository)

            MVVMTheme {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("ToDoList") }) }
                ) { padding ->
                    Navigation(
                        getTasksUseCase = getTasksUseCase,
                        addTaskUseCase = addTaskUseCase,
                        deleteTaskUseCase = deleteTaskUseCase,
                        toggleTaskUseCase = toggleTaskUseCase,
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
}

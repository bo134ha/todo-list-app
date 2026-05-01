package com.boshra.mvvm.model.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.boshra.mvvm.model.data.local.entites.TodoItem
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo_table ORDER BY id DESC")
    fun getAllTasks(): Flow<List<TodoItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(item: TodoItem)

    @Delete
    suspend fun deleteTask(item: TodoItem)

    @Update
    suspend fun updateTask(item: TodoItem)
}
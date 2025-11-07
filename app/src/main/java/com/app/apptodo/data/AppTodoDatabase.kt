package com.app.apptodo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppTodoDatabase: RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        private const val DATABASE_NAME = "table_task"
        private var instance: AppTodoDatabase? = null

        fun initialize(context: Context): AppTodoDatabase {
            return Room.databaseBuilder(
                context = context,
                klass = AppTodoDatabase::class.java,
                name = DATABASE_NAME
            ).build().also { inst -> instance = inst }
        }

        fun getInstance(): AppTodoDatabase = instance as AppTodoDatabase
    }
}
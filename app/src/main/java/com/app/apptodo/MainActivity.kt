package com.app.apptodo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.apptodo.apptodo.addtask.TodoAddTaskFragment
import com.app.apptodo.apptodo.list.TodoListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun replaceFragmentTask(fragmentTask: TodoListFragment) {
            supportFragmentManager
                .beginTransaction().replace(
                    R.id.fragment_container,
                    TodoListFragment()
                ).addToBackStack(null).commit()
        }

        supportFragmentManager
            .beginTransaction().replace(
                R.id.fragment_container,
                TodoAddTaskFragment()
            ).commit()

        if(savedInstanceState == null) {
            replaceFragmentTask(fragmentTask = TodoListFragment())
        }

    }
}
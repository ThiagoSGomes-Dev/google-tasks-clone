package com.app.apptodo.apptodo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.apptodo.databinding.ListItemsBinding

class TaskAdapter(private val context: Context, private var tasks: MutableList<Task>): RecyclerView.Adapter<TaskAdapter.AppTodoViewHold>() {
    // TODO: Espera a classe atual, e uma Classe interna a atual, que extende o ViewHolder. VH <ClasseAtual.ClasseInterna>

    fun updateData(newTasks: MutableList<Task>) {
        tasks = newTasks
    }
    class AppTodoViewHold(private val listItemsBinding: ListItemsBinding) : ViewHolder(listItemsBinding.root) {
        fun bind(task: Task) {
            listItemsBinding.textviewItem.text = task.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): AppTodoViewHold =
        AppTodoViewHold(
            ListItemsBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder( holder: AppTodoViewHold, position: Int ) {
        val task = tasks[position]
        holder.bind(task)
    }
}

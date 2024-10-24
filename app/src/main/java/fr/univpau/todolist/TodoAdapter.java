/*
 * TodoAdapter.java, 24/10/2024
 * UPPA M2TI 2024-2025
 * MIT License (MIT)
 */

package fr.univpau.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adapter for the list of todos.
 *
 * @author LucasVbr
 */
public class TodoAdapter extends ArrayAdapter<Todo> {

    /** The context of the adapter */
    private final Context context;

    /** The list of todos */
    private ArrayList<Todo> todoList;

    /**
     * Create a new adapter for the list of todos.
     * @param context The context of the adapter.
     * @param todoList The list of todos.
     */
    public TodoAdapter(Context context, ArrayList<Todo> todoList) {
        super(context, 0, todoList);

        this.context = context;
        this.todoList = todoList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Todo todoItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.todo_item, parent, false);
        }

        TextView todoTask = convertView.findViewById(R.id.task);
        TextView todoDate = convertView.findViewById(R.id.date);
        CheckBox todoCheckBox = convertView.findViewById(R.id.check);

        assert todoItem != null;
        todoCheckBox.setOnCheckedChangeListener(null);

        todoTask.setText(todoItem.getTask());
        todoDate.setText(todoItem.getDate().toString());
        todoCheckBox.setChecked(todoItem.isDone());

        todoCheckBox.setOnCheckedChangeListener(new OnCheckedTodoListener(todoItem));

        return convertView;
    }

    /** Remove all checked todos */
    public void removeChecked() {
        todoList.removeIf(Todo::isDone);
        notifyDataSetChanged();
    }

}

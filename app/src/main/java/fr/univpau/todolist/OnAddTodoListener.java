/*
 * OnAddTodoListener.java, 24/10/2024
 * UPPA M2TI 2024-2025
 * MIT License (MIT)
 */

package fr.univpau.todolist;

import android.view.View;
import android.widget.EditText;


/**
 * Listener for the add button
 *
 * @author LucasVbr
 */
public class OnAddTodoListener implements View.OnClickListener {
    private final EditText inputTask;
    private final TodoAdapter todoAdapter;

    /**
     * Create a new listener for the add button.
     * @param inputTask The input field for the task.
     * @param todoAdapter The adapter for the list of todos.
     */
    public OnAddTodoListener(EditText inputTask, TodoAdapter todoAdapter) {
        this.inputTask = inputTask;
        this.todoAdapter = todoAdapter;
    }

    @Override
    public void onClick(View view) {
        String task = inputTask.getText().toString();
        if (task.trim().isEmpty()) return;

        todoAdapter.add(new Todo(task));
        inputTask.setText("");

    }
}

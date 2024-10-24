/*
 * OnCheckedTodoListener.java, 24/10/2024
 * UPPA M2TI 2024-2025
 * MIT License (MIT)
 */

package fr.univpau.todolist;

import android.widget.CompoundButton;

/**
 * Listener for the checkbox.
 *
 * @author LucasVbr
 */
public class OnCheckedTodoListener implements CompoundButton.OnCheckedChangeListener {

    /** The task to update */
    private final Todo todo;

    /**
     * Create a new listener for the checkbox.
     * @param todo The task to update.
     */
    public OnCheckedTodoListener(Todo todo) {
        this.todo = todo;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        todo.setDone(b);
    }
}

/*
 * Todo.java, 24/10/2024
 * UPPA M2TI 2024-2025
 * MIT License (MIT)
 */

package fr.univpau.todolist;

import android.util.Log;

import java.util.Date;

/**
 * Represents a task to do.
 *
 * @author LucasVbr
 */
public class Todo {

    /** The task name */
    private final String task;

    /** The creation date */
    private final Date date;

    /** Whether the task is done */
    private boolean done;

    /**
     * Create a new task.
     * @param task The task name
     */
    public Todo(String task) {
        this.task = task;
        this.date = new Date();
        this.done = false;
    }

    /** @return The task name */
    public String getTask() {
        return task;
    }

    /** @return The creation date */
    public Date getDate() {
        return date;
    }

    /** @return Whether the task is done */
    public boolean isDone() {
        return done;
    }

    /**
     * Set whether the task is done.
     * @param done Whether the task is done
     */
    public void setDone(boolean done) {
        this.done = done;
        Log.i("Checkbox", this.toString());
    }

    @Override
    public String toString() {
        return "Task: " + task +
                ", Date: " + date +
                ", Done: " + (done ? "Yes" : "No");
    }
}

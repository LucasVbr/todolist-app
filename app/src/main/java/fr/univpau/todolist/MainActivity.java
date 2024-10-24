/*
 * MainActivity.java, 24/10/2024
 * UPPA M2TI 2024-2025
 * MIT License (MIT)
 */

package fr.univpau.todolist;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

/**
 * The main activity of the application.
 *
 * @author LucasVbr
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The adapter for the list of todos.
     */
    private TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText inputTask = findViewById(R.id.input_task);
        Button buttonAdd = findViewById(R.id.button_add);
        ListView todoListView = findViewById(R.id.todo_list);

        this.todoAdapter = new TodoAdapter(this, new ArrayList<>());
        todoListView.setAdapter(todoAdapter);

        buttonAdd.setOnClickListener(new OnAddTodoListener(inputTask, todoAdapter));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.clear_list) {
            todoAdapter.clear();
            return true;
        }

        if (id == R.id.remove_checked) {
            this.todoAdapter.removeChecked();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
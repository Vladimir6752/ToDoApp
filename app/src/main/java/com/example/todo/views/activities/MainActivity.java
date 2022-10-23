package com.example.todo.views.activities;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.todo.R;
import com.example.todo.listeners.OnClickAddToDoButtonListener;
import com.example.todo.logicClasses.StepParser;
import com.example.todo.dao.ToDoDao;
import com.example.todo.data.ToDoDatabase;
import com.example.todo.models.ToDo;
import com.example.todo.views.otherViews.ToDoCardShell;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TODO_DATABASE_NAME = "toDo-database1";
    private FloatingActionButton addToDoButton;
    private LinearLayout patternTodoLayout;
    private LinearLayout mainLayout;
    private ToDoDao toDoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToDoDatabase database = Room.databaseBuilder(
                        getApplicationContext(),
                        ToDoDatabase.class,
                        TODO_DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        toDoDao = database.getToDoDao();

        new StepParser(toDoDao);

        mainLayout = findViewById(R.id.mainLayout);
        patternTodoLayout = findViewById(R.id.patternTodo);
        addToDoButton = findViewById(R.id.addToDoButton);

        inizializeAllToDoView();
        inizialiseAddToDoButton();
    }

    private void inizialiseAddToDoButton() {
        addToDoButton.setOnClickListener(
                new OnClickAddToDoButtonListener(
                        toDoDao,
                        patternTodoLayout,
                        getApplicationContext(),
                        this
                )
        );
    }

    private void inizializeAllToDoView() {
        mainLayout.removeAllViews();



        for (ToDo todo : toDoDao.getAllToDos()) {
            mainLayout.addView(new ToDoCardShell(getApplicationContext(), todo, toDoDao));
        }
    }

    public void setNewToDo(String titleInputText) {
        ToDo toDo = new ToDo();
        toDo.setTitle(titleInputText);

        System.out.println("new todo");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd 'в' HH:mm");
        toDo.setCreatedDate(simpleDateFormat.format(date));

        toDoDao.addToDo(toDo);

        inizializeAllToDoView();
    }
}
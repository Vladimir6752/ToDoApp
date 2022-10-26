package com.example.todo.views.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.todo.R;
import com.example.todo.listeners.OnClickAddToDoButtonListener;
import com.example.todo.logicClasses.StepParser;
import com.example.todo.dao.ToDoDao;
import com.example.todo.data.ToDoDatabase;
import com.example.todo.models.Step;
import com.example.todo.models.ToDo;
import com.example.todo.views.otherViews.ToDoCardShell;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TODO_DATABASE_NAME = "toDo-database1";
    public static FloatingActionButton addToDoButton;
    private LinearLayout patternTodoLayout;
    private LinearLayout mainLayout;
    private ToDoDao toDoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoDao = Room.databaseBuilder(getApplicationContext(), ToDoDatabase.class, TODO_DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .getToDoDao();

        new StepParser(toDoDao);

        /*for (ToDo allToDo : toDoDao.getAllToDos()) {
            toDoDao.deleteToDo(allToDo);
        }

        Step step = new Step();
        step.setContent("123");
        ToDo toDo = new ToDo();
        toDo.setTitle("qrqrqwr");
        toDo.setSteps(StepParser.setStepsArray(Arrays.asList(step)));
        toDoDao.addToDo(toDo);*/

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

    public void inizializeAllToDoView() {
        mainLayout.removeAllViews();

        for (ToDo todo : toDoDao.getAllToDos()) {
            mainLayout.addView(new ToDoCardShell(getApplicationContext(), todo, toDoDao, this));
        }
    }

    @SuppressLint("SimpleDateFormat")
    public void setNewToDo(String titleInputText) {
        ToDo toDo = new ToDo();
        toDo.setTitle(titleInputText);

        toDo.setCreatedDate(
                new SimpleDateFormat("yyyy.MM.dd 'в' HH:mm")
                .format(new Date())
        );

        toDoDao.addToDo(toDo);

        inizializeAllToDoView();
    }
}
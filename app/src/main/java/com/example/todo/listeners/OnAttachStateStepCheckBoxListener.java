package com.example.todo.listeners;

import android.view.View;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.ToDo;

public class OnAttachStateStepCheckBoxListener implements View.OnAttachStateChangeListener {
    private final ToDoDao toDoDao;
    private final ToDo toDo;

    public OnAttachStateStepCheckBoxListener(ToDoDao toDoDao, ToDo toDo) {
        this.toDoDao = toDoDao;
        this.toDo = toDo;
    }

    @Override
    public void onViewAttachedToWindow(View v) {

    }

    @Override
    public void onViewDetachedFromWindow(View v) {

    }
}

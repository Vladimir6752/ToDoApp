package com.example.todo.listeners;

import android.view.View;

import com.example.todo.logicClasses.StepParser;
import com.example.todo.models.Step;
import com.example.todo.models.ToDo;

public class OnClickStepCheckBoxListener implements View.OnClickListener {
    private final ToDo toDo;
    private final Step step;

    public OnClickStepCheckBoxListener(ToDo toDo, Step step) {
        this.toDo = toDo;
        this.step = step;
    }

    @Override
    public void onClick(View v) {
        StepParser.setDoneIntoStepFromTodo(toDo, step);
    }
}

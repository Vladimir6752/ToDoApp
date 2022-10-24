package com.example.todo.views.layouts;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.Step;
import com.example.todo.models.ToDo;
import com.example.todo.views.buttons.StepCheckBox;
import com.example.todo.views.textViews.StepTextView;

@SuppressLint("ViewConstructor")
public class StepLayout extends BaseLayout {
    public StepLayout(Context context, ToDo toDo, Step step, ToDoDao toDoDao) {
        super(context, 5, HORIZONTAL);

        addView(new StepCheckBox(context, step, toDoDao, toDo));
        addView(new StepTextView(context, step.getContent()));
    }
}

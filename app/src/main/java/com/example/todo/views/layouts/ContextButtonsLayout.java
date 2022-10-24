package com.example.todo.views.layouts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.ToDo;
import com.example.todo.views.activities.MainActivity;
import com.example.todo.views.buttons.AddStepInToDoButton;
import com.example.todo.views.buttons.DeleteToDoButton;

@SuppressLint("ViewConstructor")
public class ContextButtonsLayout extends BaseLayout {
    public ContextButtonsLayout(Context context, ToDo toDo, ToDoDao toDoDao, StepContainerLayout stepContainerLayout, MainActivity mainActivity) {
        super(context, HORIZONTAL);

        addView(new AddStepInToDoButton(context, toDo, toDoDao, stepContainerLayout));
        addView(new DeleteToDoButton(context, toDo, toDoDao, mainActivity));

        setVisibility(GONE);

        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,  ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}

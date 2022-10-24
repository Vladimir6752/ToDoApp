package com.example.todo.views.buttons;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.todo.R;
import com.example.todo.dao.ToDoDao;
import com.example.todo.listeners.OnClickAddStepInToDoListener;
import com.example.todo.models.ToDo;
import com.example.todo.views.layouts.StepContainerLayout;

@SuppressLint("ViewConstructor")
public class AddStepInToDoButton extends BaseImageButton {
    public AddStepInToDoButton(Context context, ToDo toDo, ToDoDao toDoDao, StepContainerLayout stepContainerLayout) {
        super(
                context,
                R.drawable.ic_add_step,
                new OnClickAddStepInToDoListener(context, toDo, toDoDao, stepContainerLayout)
        );
    }
}

package com.example.todo.views.buttons;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageButton;

import com.example.todo.R;
import com.example.todo.dao.ToDoDao;
import com.example.todo.listeners.OnClickAddStepInToDoListener;
import com.example.todo.models.ToDo;
import com.example.todo.views.layouts.StepContainerLayout;

@SuppressLint({"ViewConstructor", "AppCompatCustomView"})
public class AddStepInToDoButton extends ImageButton {
    public AddStepInToDoButton(Context context, ToDo toDo, ToDoDao toDoDao, StepContainerLayout stepContainerLayout) {
        super(context);

        setImageResource(R.drawable.ic_add_step);
        setBackgroundColor(getResources().getColor(R.color.transparent));

        setOnClickListener(new OnClickAddStepInToDoListener(context, toDo, toDoDao, stepContainerLayout));
    }
}

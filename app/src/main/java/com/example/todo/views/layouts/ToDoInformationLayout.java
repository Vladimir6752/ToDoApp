package com.example.todo.views.layouts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.ToDo;
import com.example.todo.views.activities.MainActivity;
import com.example.todo.views.textViews.ToDoCreatedDateTextView;

@SuppressLint("ViewConstructor")
public class ToDoInformationLayout extends RelativeLayout {

    public ToDoInformationLayout(Context context, ToDo toDo, ToDoDao toDoDao, MainActivity mainActivity, StepContainerLayout stepContainerLayout) {
        super(context);

        setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        addView(new ToDoCreatedDateTextView(context, toDo));

        addView(new ContextMenuToDoLayout(context, toDo, toDoDao, stepContainerLayout, mainActivity));
    }
}

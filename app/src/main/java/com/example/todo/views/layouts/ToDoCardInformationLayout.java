package com.example.todo.views.layouts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.ToDo;

@SuppressLint("ViewConstructor")
public class ToDoCardInformationLayout extends RelativeLayout {
    public ToDoCardInformationLayout(Context context, ToDo toDo, ToDoDao toDoDao) {
        super(context);
    }
}

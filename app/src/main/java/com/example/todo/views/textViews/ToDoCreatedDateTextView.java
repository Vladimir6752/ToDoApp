package com.example.todo.views.textViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.todo.R;
import com.example.todo.models.ToDo;

@SuppressLint("ViewConstructor")
public class ToDoCreatedDateTextView extends BaseTextView {
    public ToDoCreatedDateTextView(Context context, ToDo toDo) {
        super(
                context,
                R.color.gray,
                15,
                toDo.getCreatedDate()
        );
    }
}

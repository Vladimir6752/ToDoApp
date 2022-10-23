package com.example.todo.views.textViews;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.todo.R;
import com.example.todo.models.ToDo;

@SuppressLint({"AppCompatCustomView", "ViewConstructor"})
public class ToDoTitleTextView extends BaseTextView {
    public ToDoTitleTextView(Context context, ToDo toDo) {
        super(
                context,
                R.color.black,
                20,
                toDo.getTitle()
        );
    }
}

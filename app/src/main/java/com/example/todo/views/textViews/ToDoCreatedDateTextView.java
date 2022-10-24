package com.example.todo.views.textViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

        setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
    }
}

package com.example.todo.views.textViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

        setParams();
    }

    private void setParams() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);;
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);

        setLayoutParams(params);
    }
}

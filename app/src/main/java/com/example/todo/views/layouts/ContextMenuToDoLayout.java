package com.example.todo.views.layouts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.ToDo;
import com.example.todo.views.activities.MainActivity;
import com.example.todo.views.buttons.OpenToDoContextMenuButton;

@SuppressLint("ViewConstructor")
public class ContextMenuToDoLayout extends BaseLayout {
    public ContextMenuToDoLayout(Context context, ToDo toDo, ToDoDao toDoDao, StepContainerLayout stepContainerLayout, MainActivity mainActivity) {
        super(context, HORIZONTAL);

        setParams();

        inizializeContextMenu(context, toDo, toDoDao, mainActivity, stepContainerLayout);
    }

    private void setParams() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);;
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        setLayoutParams(params);
    }

    private void inizializeContextMenu(Context context, ToDo toDo, ToDoDao toDoDao, MainActivity mainActivity, StepContainerLayout stepContainerLayout) {
        ContextButtonsLayout contextButtonsLayout = new ContextButtonsLayout(context, toDo, toDoDao, stepContainerLayout, mainActivity);

        addView(contextButtonsLayout);

        addView(new OpenToDoContextMenuButton(context, contextButtonsLayout));
    }
}

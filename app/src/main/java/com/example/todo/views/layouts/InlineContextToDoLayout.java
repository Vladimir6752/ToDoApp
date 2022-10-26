package com.example.todo.views.layouts;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.ToDo;
import com.example.todo.views.activities.MainActivity;
import com.example.todo.views.otherViews.ToDoCardView;

@SuppressLint("ViewConstructor")
public class InlineContextToDoLayout extends BaseLayout{
    public final StepContainerLayout stepContainer;

    public InlineContextToDoLayout(Context context, ToDoCardView toDoCardView, ToDo toDo, ToDoDao toDoDao, MainActivity mainActivity) {
        super(context);

        addView(stepContainer = new StepContainerLayout(context, toDoCardView));

        addView(new ToDoInformationLayout(context, toDo, toDoDao, mainActivity, stepContainer));

        setVisibility(GONE);
    }
}

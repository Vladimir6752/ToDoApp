package com.example.todo.listeners;

import android.content.Context;
import android.view.View;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.ToDo;
import com.example.todo.views.layouts.StepContainerLayout;
import com.example.todo.views.layouts.StepPatternLayout;

public class OnClickAddStepInToDoListener implements View.OnClickListener {
    private final StepPatternLayout stepPatternLayout;

    public OnClickAddStepInToDoListener(Context context, ToDo toDo, ToDoDao toDoDao, StepContainerLayout stepContainerLayout) {
        this.stepPatternLayout = stepContainerLayout.stepPatternLayout;
    }

    @Override
    public void onClick(View v) {
        stepPatternLayout.setVisibility(
                stepPatternLayout.getVisibility() == View.GONE
                        ? View.VISIBLE : View.GONE);
    }
}

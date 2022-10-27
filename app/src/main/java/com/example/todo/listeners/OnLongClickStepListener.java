package com.example.todo.listeners;

import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.todo.dao.ToDoDao;
import com.example.todo.logicClasses.StepParser;
import com.example.todo.models.Step;
import com.example.todo.models.ToDo;
import com.example.todo.views.activities.MainActivity;
import com.example.todo.views.layouts.StepContainerLayout;
import com.example.todo.views.layouts.StepLayout;

public class OnLongClickStepListener implements View.OnLongClickListener {
    private final StepContainerLayout stepContainerLayout;
    private final StepLayout stepLayout;
    private final ToDo toDo;
    private final Step step;

    public OnLongClickStepListener(ToDo toDo, Step step, StepLayout stepLayout, StepContainerLayout stepContainerLayout) {
        this.stepContainerLayout = stepContainerLayout;
        this.stepLayout = stepLayout;
        this.toDo = toDo;
        this.step = step;
    }

    @Override
    public boolean onLongClick(View v) {
        StepParser.removeStepInToDo(toDo, step);
        stepContainerLayout.toDoCardView.initializeSteps();

        return true;
    }
}

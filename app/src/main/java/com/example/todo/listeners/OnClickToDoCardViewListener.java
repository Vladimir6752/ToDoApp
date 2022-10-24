package com.example.todo.listeners;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.view.View;

import com.example.todo.views.layouts.StepContainerLayout;
import com.example.todo.views.otherViews.ToDoCardShell;

public class OnClickToDoCardViewListener implements View.OnClickListener {
    private final StepContainerLayout stepContainer;
    private final ToDoCardShell toDoCardShell;

    public OnClickToDoCardViewListener(StepContainerLayout stepContainer, ToDoCardShell toDoCardShell) {
        this.stepContainer = stepContainer;
        this.toDoCardShell = toDoCardShell;
    }

    @Override
    public void onClick(View v) {
        int visibility = stepContainer.getVisibility() == GONE ? VISIBLE : GONE;

        // TODO: 23.10.2022 Animate step container
        toDoCardShell.setContentPadding(25,25,25, stepContainer.getVisibility() == GONE ? 10 : 25);

        stepContainer.setVisibility(visibility);
    }
}

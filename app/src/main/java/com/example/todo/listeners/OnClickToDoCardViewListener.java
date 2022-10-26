package com.example.todo.listeners;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.view.View;

import com.example.todo.views.layouts.InlineContextToDoLayout;
import com.example.todo.views.layouts.StepContainerLayout;
import com.example.todo.views.otherViews.ToDoCardShell;

public class OnClickToDoCardViewListener implements View.OnClickListener {
    private final InlineContextToDoLayout inlineContextToDoLayout;
    private final ToDoCardShell toDoCardShell;

    public OnClickToDoCardViewListener(InlineContextToDoLayout inlineContextToDoLayout, ToDoCardShell toDoCardShell) {
        this.inlineContextToDoLayout = inlineContextToDoLayout;

        this.toDoCardShell = toDoCardShell;
    }

    @Override
    public void onClick(View v) {
        int visibility = inlineContextToDoLayout.getVisibility() == GONE ? VISIBLE : GONE;

        // TODO: 23.10.2022 Animate step container
        toDoCardShell.setContentPadding(25,25,25, inlineContextToDoLayout.getVisibility() == GONE ? 10 : 25);

        inlineContextToDoLayout.setVisibility(visibility);
    }
}

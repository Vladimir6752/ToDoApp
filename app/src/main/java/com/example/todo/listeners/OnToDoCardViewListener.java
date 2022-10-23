package com.example.todo.listeners;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;

import com.example.todo.views.layouts.StepContainerLayout;

public class OnToDoCardViewListener implements View.OnClickListener {
    private final StepContainerLayout stepContainer;

    public OnToDoCardViewListener(StepContainerLayout stepContainer) {
        this.stepContainer = stepContainer;
    }

    @Override
    public void onClick(View v) {
        int visibility = stepContainer.getVisibility() == GONE ? VISIBLE : GONE;

        // TODO: 23.10.2022 Animate step container

        stepContainer.setVisibility(visibility);
    }
}

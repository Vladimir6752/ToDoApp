package com.example.todo.views.layouts;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.todo.views.otherViews.ToDoCardView;

@SuppressLint("ViewConstructor")
public class StepContainerLayout extends BaseLayout {
    public final StepPatternLayout stepPatternLayout;

    public StepContainerLayout(Context context, ToDoCardView toDoCardView) {
        super(context, 0, VERTICAL);
        setVisibility(GONE);

        addView(stepPatternLayout = new StepPatternLayout(context), getChildCount() - 1);
    }

    public void addStep(StepLayout stepLayout) {
        addView(stepLayout, getChildCount() - 1);
    }
}

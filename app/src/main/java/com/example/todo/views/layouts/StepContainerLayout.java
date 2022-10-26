package com.example.todo.views.layouts;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.todo.models.Step;
import com.example.todo.models.ToDo;
import com.example.todo.views.otherViews.ToDoCardView;

@SuppressLint("ViewConstructor")
public class StepContainerLayout extends BaseLayout {
    public final StepPatternLayout stepPatternLayout;
    public final ToDoCardView toDoCardView;

    public StepContainerLayout(Context context, ToDoCardView toDoCardView) {
        super(context, 0, VERTICAL);
        this.toDoCardView = toDoCardView;

        addView(stepPatternLayout = new StepPatternLayout(context), getChildCount());
    }

    public void addStep(Context context, ToDo toDo, Step step) {
        addView(new StepLayout(context, toDo, step, this), getChildCount() - 1);
    }
}

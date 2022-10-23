package com.example.todo.views.otherViews;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;

import com.example.todo.R;
import com.example.todo.logicClasses.StepParser;
import com.example.todo.dao.ToDoDao;
import com.example.todo.listeners.OnToDoCardViewListener;
import com.example.todo.models.Step;
import com.example.todo.models.ToDo;
import com.example.todo.views.layouts.BaseLayout;
import com.example.todo.views.layouts.StepContainerLayout;
import com.example.todo.views.layouts.StepLayout;
import com.example.todo.views.textViews.ToDoCreatedDateTextView;
import com.example.todo.views.textViews.ToDoTitleTextView;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ViewConstructor")
public class ToDoCardView extends BaseLayout {
    private final ToDoDao toDoDao;
    private StepContainerLayout stepContainer;

    public ToDoCardView(Context context, ToDo toDo, ToDoDao toDoDao) {
        super(context, VERTICAL);
        this.toDoDao = toDoDao;

        initializeToDoCardView(context, toDo);
    }

    private void initializeToDoCardView(Context context, ToDo toDo) {
        setToDoView(context, toDo);

        setBackgroundColor(getResources().getColor(R.color.white));
    }

    private void setToDoView(Context context, ToDo toDo) {
        addView(new ToDoTitleTextView(context, toDo));

        stepContainer = new StepContainerLayout(context);

        addView(stepContainer);

        stepContainer.addView(new ToDoCreatedDateTextView(context, toDo));

        initializeSteps(context, toDo);
    }

    public StepContainerLayout getStepContainer() {
        return stepContainer;
    }

    private void initializeSteps(Context context, ToDo toDo) {
        for (StepLayout stepLayout : getToDoStepsView(context, toDo)) {
            stepContainer.addView(stepLayout);
        }
    }

    private List<StepLayout> getToDoStepsView(Context context, ToDo toDo) {
        List<StepLayout> result = new ArrayList<>();

        for (Step step : StepParser.getStepsByToDo(toDo)) {
            result.add(new StepLayout(context, toDo, step, toDoDao));
        }

        return result;
    }
}

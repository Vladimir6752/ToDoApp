package com.example.todo.views.otherViews;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.todo.R;
import com.example.todo.logicClasses.StepParser;
import com.example.todo.dao.ToDoDao;
import com.example.todo.models.Step;
import com.example.todo.models.ToDo;
import com.example.todo.views.activities.MainActivity;
import com.example.todo.views.layouts.BaseLayout;
import com.example.todo.views.layouts.StepContainerLayout;
import com.example.todo.views.layouts.StepLayout;
import com.example.todo.views.layouts.ToDoCardInformationLayout;
import com.example.todo.views.textViews.ToDoTitleTextView;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ViewConstructor")
public class ToDoCardView extends BaseLayout {
    private final ToDo toDo;
    private final MainActivity mainActivity;
    private StepContainerLayout stepContainer;
    private final ToDoDao toDoDao;

    public ToDoCardView(Context context, ToDo toDo, MainActivity mainActivity, ToDoDao toDoDao) {
        super(context, VERTICAL);

        this.mainActivity = mainActivity;
        this.toDoDao = toDoDao;
        this.toDo = toDo;

        initializeToDoCardView(context);
    }

    private void initializeToDoCardView(Context context) {
        setToDoView(context, toDo);

        setBackgroundColor(getResources().getColor(R.color.white));
    }

    private void setToDoView(Context context, ToDo toDo) {
        addView(new ToDoTitleTextView(context, toDo));

        addView(stepContainer = new StepContainerLayout(context, this));

        initializeSteps(context);

        stepContainer.addView(new ToDoCardInformationLayout(context, toDo, toDoDao, mainActivity, stepContainer));
    }

    public StepContainerLayout getStepContainer() {
        return stepContainer;
    }

    public void initializeSteps(Context context) {
        for (Step step : StepParser.getStepsByToDo(toDo)) {
            stepContainer.addStep(new StepLayout(context, toDo, step, toDoDao));
        }
    }
}

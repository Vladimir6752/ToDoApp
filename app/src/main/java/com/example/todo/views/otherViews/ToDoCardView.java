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
    private final MainActivity mainActivity;
    private StepContainerLayout stepContainer;
    private final ToDoDao toDoDao;

    public ToDoCardView(Context context, ToDo toDo, MainActivity mainActivity, ToDoDao toDoDao) {
        super(context, VERTICAL);
        this.mainActivity = mainActivity;
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

        stepContainer.addView(new ToDoCardInformationLayout(context, toDo, toDoDao, mainActivity, stepContainer));

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

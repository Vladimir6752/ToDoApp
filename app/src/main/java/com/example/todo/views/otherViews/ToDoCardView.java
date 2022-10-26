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
import com.example.todo.views.layouts.InlineContextToDoLayout;
import com.example.todo.views.layouts.StepContainerLayout;
import com.example.todo.views.layouts.StepPatternLayout;
import com.example.todo.views.textViews.ToDoTitleTextView;

@SuppressLint("ViewConstructor")
public class ToDoCardView extends BaseLayout {
    private final ToDo toDo;
    private final Context context;
    private final MainActivity mainActivity;
    private final ToDoDao toDoDao;
    public InlineContextToDoLayout inlineContextToDoLayout;

    public ToDoCardView(Context context, ToDo toDo, MainActivity mainActivity, ToDoDao toDoDao) {
        super(context, VERTICAL);

        this.mainActivity = mainActivity;
        this.toDoDao = toDoDao;
        this.context = context;
        this.toDo = toDo;

        initializeToDoCardView();
    }

    private void initializeToDoCardView() {
        setToDoView(toDo);

        setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void setToDoView(ToDo toDo) {
        addView(new ToDoTitleTextView(context, toDo));

        addView(inlineContextToDoLayout = new InlineContextToDoLayout(context, this, toDo, toDoDao, mainActivity));

        initializeSteps();
    }

    public void initializeSteps() {
        StepContainerLayout stepContainer = inlineContextToDoLayout.stepContainer;

        removeAllSteps(stepContainer);

        for (Step step : StepParser.getStepsByToDo(toDo)) {
            stepContainer.addStep(context, toDo, step);
        }
    }

    private void removeAllSteps(StepContainerLayout stepContainer) {
        for (int i = 0; i < stepContainer.getChildCount(); i++) {
            if(isStepPatternLayout(stepContainer, i)) {
                continue;
            }

            stepContainer.removeViewAt(i);
        }
    }

    private boolean isStepPatternLayout(StepContainerLayout stepContainer, int i) {
        return stepContainer.getChildAt(i) instanceof StepPatternLayout;
    }
}

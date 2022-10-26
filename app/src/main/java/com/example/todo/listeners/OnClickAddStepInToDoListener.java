package com.example.todo.listeners;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.todo.dao.ToDoDao;
import com.example.todo.logicClasses.StepParser;
import com.example.todo.models.Step;
import com.example.todo.models.ToDo;
import com.example.todo.views.activities.MainActivity;
import com.example.todo.views.layouts.StepContainerLayout;
import com.example.todo.views.layouts.StepPatternLayout;

public class OnClickAddStepInToDoListener implements View.OnClickListener {
    private final StepContainerLayout stepContainerLayout;
    private final InputMethodManager activitySystemService;
    private final StepPatternLayout stepPatternLayout;
    private final ToDoDao toDoDao;
    private final Context context;
    private final ToDo toDo;

    public OnClickAddStepInToDoListener(Context context, ToDo toDo, ToDoDao toDoDao, StepContainerLayout stepContainerLayout, MainActivity mainActivity) {
        this.stepPatternLayout = stepContainerLayout.stepPatternLayout;
        this.stepContainerLayout = stepContainerLayout;
        this.toDoDao = toDoDao;
        this.context = context;
        this.toDo = toDo;

        activitySystemService = (InputMethodManager) mainActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Override
    public void onClick(View v) {
        int visibility = stepPatternLayout.getVisibility();

        if(visibility == View.GONE) {
            activitySystemService.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            stepPatternLayout.setVisibility(View.VISIBLE);
            MainActivity.addToDoButton.setVisibility(View.GONE);
        }
        else {
            activitySystemService.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS, 0);
            MainActivity.addToDoButton.setVisibility(View.VISIBLE);
            stepPatternLayout.setVisibility(View.GONE);
            resetPatternStep();
        }

        stepPatternLayout.stepText.requestFocus();
    }

    private void resetPatternStep() {
        String titleInputText = stepPatternLayout.stepText.getText().toString();
        stepPatternLayout.stepText.setText("");

        if(titleInputText.equals("")) {
            return;
        }

        Step step = new Step();
        step.setId(StepParser.getStepsCountInToDo(toDo));
        step.setContent(titleInputText);

        StepParser.addStepIntoTodo(toDo, step);

        stepContainerLayout.addStep(context, toDo, step);
    }
}

package com.example.todo.views.layouts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.ToDo;
import com.example.todo.views.activities.MainActivity;
import com.example.todo.views.buttons.AddStepInToDoButton;
import com.example.todo.views.buttons.DeleteToDoButton;
import com.example.todo.views.textViews.ToDoCreatedDateTextView;

@SuppressLint("ViewConstructor")
public class ToDoCardInformationLayout extends RelativeLayout {
    private final MainActivity mainActivity;
    private StepContainerLayout stepContainerLayout;
    private ToDoDao toDoDao;
    private Context context;
    private ToDo toDo;

    public ToDoCardInformationLayout(Context context, ToDo toDo, ToDoDao toDoDao, MainActivity mainActivity, StepContainerLayout stepContainerLayout) {
        super(context);
        this.mainActivity = mainActivity;
        this.toDo = toDo;
        this.toDoDao = toDoDao;
        this.context = context;
        this.stepContainerLayout = stepContainerLayout;

        setParams();

        inizializeToDoCreatedDateTextView();
        inizializeDeleteToDoButton();
        inizializeAddStepInToDoButton();
    }

    private void inizializeAddStepInToDoButton() {
        AddStepInToDoButton addStepInToDoButton = new AddStepInToDoButton(context, toDo, toDoDao, stepContainerLayout);
        addView(addStepInToDoButton);

        RelativeLayout.LayoutParams params = getLayoutParam();
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);

        addStepInToDoButton.setLayoutParams(params);
    }

    private void inizializeDeleteToDoButton() {
        DeleteToDoButton deleteToDoButton = new DeleteToDoButton(context, toDo, toDoDao, this.mainActivity);
        addView(deleteToDoButton);

        RelativeLayout.LayoutParams params = getLayoutParam();
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        deleteToDoButton.setLayoutParams(params);
    }

    private void inizializeToDoCreatedDateTextView() {
        ToDoCreatedDateTextView toDoCreatedDateTextView = new ToDoCreatedDateTextView(context, toDo);
        addView(toDoCreatedDateTextView);

        RelativeLayout.LayoutParams params = getLayoutParam();
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);

        toDoCreatedDateTextView.setLayoutParams(params);
    }

    private void setParams() {
        setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }

    private RelativeLayout.LayoutParams getLayoutParam() {
        return new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

}

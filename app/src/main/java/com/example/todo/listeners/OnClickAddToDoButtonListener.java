package com.example.todo.listeners;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.example.todo.dao.ToDoDao;
import com.example.todo.views.activities.MainActivity;
import com.example.todo.views.otherViews.ToDoPatternView;

public class OnClickAddToDoButtonListener implements View.OnClickListener {
    private final ToDoPatternView toDoPatternView;
    private final MainActivity mainActivity;
    private final InputMethodManager activitySystemService;

    public OnClickAddToDoButtonListener(ToDoDao toDoDao, LinearLayout mainLayout, Context context, MainActivity mainActivity) {
        this.mainActivity = mainActivity;

        activitySystemService = (InputMethodManager) mainActivity.getSystemService(Context.INPUT_METHOD_SERVICE);

        mainLayout.addView(toDoPatternView = new ToDoPatternView(context, toDoDao), 0);
    }

    @Override
    public void onClick(View v) {
        int visibility = toDoPatternView.getVisibility();

        if(visibility == View.GONE) {
            activitySystemService.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            toDoPatternView.setVisibility(View.VISIBLE);
        }
        else {
            activitySystemService.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS, 0);
            toDoPatternView.setVisibility(View.GONE);
            resetPatternToDo();
        }

        ToDoPatternView.titleToDoTextView.requestFocus();
    }

    private void resetPatternToDo() {
        String titleInputText = ToDoPatternView.getTitleInputText();
        ToDoPatternView.setTitleToDoTextView("");

        if(titleInputText.equals("")) {
            return;
        }

        mainActivity.setNewToDo(titleInputText);
    }
}

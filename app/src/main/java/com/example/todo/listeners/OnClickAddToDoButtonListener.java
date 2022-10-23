package com.example.todo.listeners;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.example.todo.dao.ToDoDao;
import com.example.todo.views.activities.MainActivity;
import com.example.todo.views.otherViews.PatternToDoView;

public class OnClickAddToDoButtonListener implements View.OnClickListener {
    private final PatternToDoView patternToDoView;
    private final ToDoDao toDoDao;
    private final Context context;
    private final MainActivity mainActivity;
    private InputMethodManager activitySystemService;

    public OnClickAddToDoButtonListener(ToDoDao toDoDao, LinearLayout mainLayout, Context context, MainActivity mainActivity) {
        this.toDoDao = toDoDao;
        this.context = context;
        this.mainActivity = mainActivity;

        activitySystemService = (InputMethodManager) mainActivity.getSystemService(Context.INPUT_METHOD_SERVICE);

        mainLayout.addView(patternToDoView = new PatternToDoView(context, toDoDao), 0);
    }

    @Override
    public void onClick(View v) {
        int visibility = patternToDoView.getVisibility();

        if(visibility == View.GONE) {
            activitySystemService.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            patternToDoView.setVisibility(View.VISIBLE);
        }
        else {
            activitySystemService.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS, 0);
            patternToDoView.setVisibility(View.GONE);
            resetPatternToDo();
        }

        patternToDoView.setFocusOnTextEdit();
    }

    private void resetPatternToDo() {
        String titleInputText = PatternToDoView.getTitleInputText();
        PatternToDoView.setTitleToDoTextView("");

        if(titleInputText.equals("")) {
            return;
        }

        mainActivity.setNewToDo(titleInputText);
    }
}

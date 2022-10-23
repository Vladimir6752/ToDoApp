package com.example.todo.views.otherViews;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;

import com.example.todo.dao.ToDoDao;
import com.example.todo.views.layouts.BaseLayout;

@SuppressLint("ViewConstructor")
public class PatternToDoView extends CardView {

    private static EditText titleToDoTextView;
    private final BaseLayout layout;

    public PatternToDoView(Context context, ToDoDao toDoDao) {
        super(context);

        setLayoutParams();

        addView(layout = new BaseLayout(context, LinearLayout.VERTICAL));

        inizializeContent(context);
    }

    private void inizializeContent(Context context) {
        titleToDoTextView = new EditText(context);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        titleToDoTextView.setLayoutParams(layoutParams);
        titleToDoTextView.setHint("Текст дела");
        setVisibility(GONE);
        titleToDoTextView.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        layout.addView(titleToDoTextView);
    }

    public static String getTitleInputText() {
        String s = titleToDoTextView.getText().toString();

        return s;
    }

    public static void setTitleToDoTextView(String text) {
        titleToDoTextView.setText(text);
    }

    private void setLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(15,15,15,15);

        setRadius(30f);

        setContentPadding(25,25,25,25);

        setLayoutParams(layoutParams);

        setLayoutTransition(inizializeLayoutTransition());
    }

    private LayoutTransition inizializeLayoutTransition() {
        LayoutTransition layoutTransition = new LayoutTransition();

        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);

        return layoutTransition;
    }

    public void setFocusOnTextEdit() {
        titleToDoTextView.requestFocus();
    }
}

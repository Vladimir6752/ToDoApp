package com.example.todo.views.otherViews;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;

import com.example.todo.dao.ToDoDao;

@SuppressLint("ViewConstructor")
public class ToDoPatternView extends CardView {

    public static BaseEditText titleToDoTextView;

    public ToDoPatternView(Context context, ToDoDao toDoDao) {
        super(context);

        setLayoutParams();

        inizializeContent(context);
    }

    private void inizializeContent(Context context) {
        addView(titleToDoTextView = new BaseEditText(
                context,
                "Текст дела",
                20,
                0));

        setVisibility(GONE);
    }

    public static String getTitleInputText() {
        return titleToDoTextView.getText().toString();
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

        setContentPadding(15,15,15,15);

        setLayoutParams(layoutParams);

        setLayoutTransition(inizializeLayoutTransition());
    }

    private LayoutTransition inizializeLayoutTransition() {
        LayoutTransition layoutTransition = new LayoutTransition();

        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);

        return layoutTransition;
    }
}

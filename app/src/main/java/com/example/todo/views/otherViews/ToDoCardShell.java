package com.example.todo.views.otherViews;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;

import com.example.todo.dao.ToDoDao;
import com.example.todo.listeners.OnClickToDoCardViewListener;
import com.example.todo.models.ToDo;
import com.example.todo.views.activities.MainActivity;

@SuppressLint("ViewConstructor")
public class ToDoCardShell extends CardView {
    private final ToDoCardView toDoCardView;
    private final MainActivity mainActivity;

    public ToDoCardShell(Context context, ToDo toDo, ToDoDao toDoDao, MainActivity mainActivity) {
        super(context);
        this.mainActivity = mainActivity;
        setLayoutParams();

        addView(toDoCardView = new ToDoCardView(context, toDo, this.mainActivity, toDoDao));

        this.setOnClickListener(new OnClickToDoCardViewListener(toDoCardView.getStepContainer(), this));
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
}

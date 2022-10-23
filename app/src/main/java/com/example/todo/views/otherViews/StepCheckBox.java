package com.example.todo.views.otherViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.todo.dao.ToDoDao;
import com.example.todo.listeners.OnAttachStateStepCheckBoxListener;
import com.example.todo.models.Step;
import com.example.todo.models.ToDo;

@SuppressLint({"AppCompatCustomView", "ViewConstructor"})
public class StepCheckBox extends CheckBox {

    public StepCheckBox(Context context, Step step, ToDoDao toDoDao, ToDo toDo) {
        super(context);

        setChecked(step.isDone());

        setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        setGravity(Gravity.VERTICAL_GRAVITY_MASK);

        addOnAttachStateChangeListener(new OnAttachStateStepCheckBoxListener(toDoDao, toDo));
    }
}

package com.example.todo.views.buttons;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.todo.listeners.OnClickStepCheckBoxListener;
import com.example.todo.models.Step;
import com.example.todo.models.ToDo;

@SuppressLint({"AppCompatCustomView", "ViewConstructor"})
public class StepCheckBox extends CheckBox {

    public StepCheckBox(Context context, Step step, ToDo toDo) {
        super(context);

        setChecked(step.isDone());

        setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        setPadding(12,12,12,12);

        setGravity(Gravity.VERTICAL_GRAVITY_MASK);

        setOnClickListener(new OnClickStepCheckBoxListener(toDo, step));
    }
}

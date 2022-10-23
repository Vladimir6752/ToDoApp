package com.example.todo.views.textViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;

import com.example.todo.R;

@SuppressLint({"AppCompatCustomView", "ViewConstructor"})
public class StepTextView extends BaseTextView {
    public StepTextView(Context context, String content) {
        super(
                context,
                R.color.black,
                20,
                content
        );

        setGravity(Gravity.VERTICAL_GRAVITY_MASK);
    }
}

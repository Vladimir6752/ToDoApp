package com.example.todo.views.layouts;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.todo.views.otherViews.BaseEditText;

public class StepPatternLayout extends BaseLayout {
    private static BaseEditText stepText;

    public StepPatternLayout(Context context) {
        super(context, 5, HORIZONTAL);

        addView(new CheckBox(context));

        addView(stepText = new BaseEditText(context, "Шаг", 12));

        setVisibility(GONE);
    }
}

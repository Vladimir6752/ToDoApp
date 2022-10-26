package com.example.todo.views.layouts;

import android.content.Context;
import android.widget.CheckBox;

import com.example.todo.R;
import com.example.todo.views.otherViews.BaseEditText;

public class StepPatternLayout extends BaseLayout {
    private final CheckBox checkBox;
    public final BaseEditText stepText;

    public StepPatternLayout(Context context) {
        super(context, HORIZONTAL);

        addView(checkBox = new CheckBox(context));

        addView(
                stepText = new BaseEditText(
                        context,
                        "Шаг",
                        12,
                        15,0,-5,0
                )
        );

        setVisibility(GONE);

        setParam();
    }

    private void setParam() {
        stepText.setTextAppearance(androidx.appcompat.R.style.TextAppearance_AppCompat_Medium);
        stepText.setTextColor(getResources().getColor(R.color.black));

        //stepText.setMargin(5,0,-5, 0);
        setMargin(5,-13,5,-13);
    }
}

package com.example.todo.views.layouts;

import android.content.Context;
import android.widget.LinearLayout;

public class BaseLayout extends LinearLayout {
    public BaseLayout(Context context) {
        this(context, 0, VERTICAL);
    }

    public BaseLayout(Context context, int orientation) {
        this(context, 0, orientation);
    }

    public BaseLayout(Context context, int margins, int orientation) {
        super(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(margins,margins,margins,margins);

        setOrientation(orientation);

        setLayoutParams(layoutParams);
    }
}

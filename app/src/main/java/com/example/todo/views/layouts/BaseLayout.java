package com.example.todo.views.layouts;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class BaseLayout extends LinearLayout {

    private LayoutParams layoutParams;

    public BaseLayout(Context context) {
        this(context, 0, VERTICAL);
    }

    public BaseLayout(Context context, int orientation) {
        this(context, 0, orientation);
    }

    public BaseLayout(Context context, int margins, int orientation) {
        super(context);
        layoutParams = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(margins,margins,margins,margins);

        setOrientation(orientation);

        setLayoutParams(layoutParams);
    }

    public void setMargin(int left, int top, int right, int bottom) {
        layoutParams.setMargins(left, top, right, bottom);
        setLayoutParams(layoutParams);
    }
}

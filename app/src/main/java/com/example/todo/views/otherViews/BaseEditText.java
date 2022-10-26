package com.example.todo.views.otherViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;

@SuppressLint({"AppCompatCustomView", "ViewConstructor"})
public class BaseEditText extends EditText {

    private final LinearLayout.LayoutParams layoutParams;

    public BaseEditText(Context context, String hint, int textSize, int margins) {
        this(context, hint, textSize, margins, margins, margins, margins);
    }

    public BaseEditText(Context context, String hint, int textSize, int left,  int top, int right, int bottom) {
        super(context);

        layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(left, top, right, bottom);
        setLayoutParams(layoutParams);
        setHint(hint);
        setTextSize(textSize);
        setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
    }

    public void setMargin(int left, int top, int right, int bottom) {
        layoutParams.setMargins(left, top, right, bottom);
        setLayoutParams(layoutParams);
    }
}

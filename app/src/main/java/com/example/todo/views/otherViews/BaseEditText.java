package com.example.todo.views.otherViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;

@SuppressLint({"AppCompatCustomView", "ViewConstructor"})
public class BaseEditText extends EditText {
    public BaseEditText(Context context, String hint, int textSize) {
        super(context);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        setLayoutParams(layoutParams);
        setHint(hint);
        setTextSize(textSize);
        setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
    }
}

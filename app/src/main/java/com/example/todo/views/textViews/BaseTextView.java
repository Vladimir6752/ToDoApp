package com.example.todo.views.textViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.todo.R;

@SuppressLint("AppCompatCustomView")
public class BaseTextView extends TextView {
    public BaseTextView(Context context) {
        this(context, R.color.black, 10, "Lorem ipsum");
    }

    public BaseTextView(Context context, int color, int size, String content) {
        super(context);
        setText(content);
        setTextSize(size);

        setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        setTextColor(getResources().getColor(color));
    }
}

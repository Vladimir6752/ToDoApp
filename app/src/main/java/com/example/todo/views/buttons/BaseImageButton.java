package com.example.todo.views.buttons;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageButton;

import com.example.todo.R;

@SuppressLint({"AppCompatCustomView", "ViewConstructor"})
public class BaseImageButton extends ImageButton {
    public BaseImageButton(Context context, int idImageBackground, OnClickListener onClickListener) {
        super(context);

        setImageResource(idImageBackground);
        setBackgroundColor(getResources().getColor(R.color.transparent));

        setOnClickListener(onClickListener);

        setPadding(10,10,10,10);
    }
}

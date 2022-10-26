package com.example.todo.views.buttons;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.todo.R;
import com.example.todo.listeners.OnClickContextMenuListener;
import com.example.todo.views.layouts.BaseLayout;

@SuppressLint({"ViewConstructor", "AppCompatCustomView"})
public class OpenToDoContextMenuButton extends BaseImageButton {
    public OpenToDoContextMenuButton(Context context, BaseLayout contextButtonsLayout) {
        super(
                context,
                R.drawable.ic_open_context_todo,
                null
        );

        setOnClickListener(new OnClickContextMenuListener(contextButtonsLayout, this));
    }
}

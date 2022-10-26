package com.example.todo.listeners;

import android.view.View;

import com.example.todo.views.buttons.OpenToDoContextMenuButton;
import com.example.todo.views.layouts.BaseLayout;

public class OnClickContextMenuListener implements View.OnClickListener {
    private final BaseLayout contextButtonsLayout;
    private final OpenToDoContextMenuButton thisButton;

    public OnClickContextMenuListener(BaseLayout contextButtonsLayout, OpenToDoContextMenuButton thisButton) {
        this.contextButtonsLayout = contextButtonsLayout;
        this.thisButton = thisButton;
    }

    @Override
    public void onClick(View v) {
        contextButtonsLayout.setVisibility(
                contextButtonsLayout.getVisibility() == View.VISIBLE
                        ? View.GONE : View.VISIBLE);
        thisButton.setRotation(thisButton.getRotation() + 180);
    }
}

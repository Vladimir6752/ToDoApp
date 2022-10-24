package com.example.todo.views.buttons;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageButton;

import com.example.todo.R;
import com.example.todo.dao.ToDoDao;
import com.example.todo.listeners.OnClickDeleteToDoButton;
import com.example.todo.models.ToDo;
import com.example.todo.views.activities.MainActivity;

@SuppressLint({"ViewConstructor", "AppCompatCustomView"})
public class DeleteToDoButton extends ImageButton {
    private final MainActivity mainActivity;

    public DeleteToDoButton(Context context, ToDo toDo, ToDoDao toDoDao, MainActivity mainActivity) {
        super(context);
        this.mainActivity = mainActivity;

        setImageResource(R.drawable.ic_delete_todo);
        setBackgroundColor(getResources().getColor(R.color.transparent));

        setOnClickListener(new OnClickDeleteToDoButton(toDo, toDoDao, this.mainActivity));
    }
}

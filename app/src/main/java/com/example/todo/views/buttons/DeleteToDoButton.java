package com.example.todo.views.buttons;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.todo.R;
import com.example.todo.dao.ToDoDao;
import com.example.todo.listeners.OnClickDeleteToDoButton;
import com.example.todo.models.ToDo;
import com.example.todo.views.activities.MainActivity;

@SuppressLint({"ViewConstructor", "AppCompatCustomView"})
public class DeleteToDoButton extends BaseImageButton {
    public DeleteToDoButton(Context context, ToDo toDo, ToDoDao toDoDao, MainActivity mainActivity) {
        super(
                context,
                R.drawable.ic_delete_todo,
                new OnClickDeleteToDoButton(toDo, toDoDao, mainActivity)
        );
    }
}

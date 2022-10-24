package com.example.todo.listeners;

import android.view.View;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.ToDo;
import com.example.todo.views.activities.MainActivity;

public class OnClickDeleteToDoButton implements View.OnClickListener {
    private final MainActivity mainActivity;
    private final ToDoDao toDoDao;
    private final ToDo toDo;


    public OnClickDeleteToDoButton(ToDo toDo, ToDoDao toDoDao, MainActivity mainActivity) {
        this.toDo = toDo;
        this.toDoDao = toDoDao;
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        toDoDao.deleteToDo(toDo);
        mainActivity.inizializeAllToDoView();
    }
}

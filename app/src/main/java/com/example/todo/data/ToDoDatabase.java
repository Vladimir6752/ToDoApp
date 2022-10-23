package com.example.todo.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.ToDo;

@Database(
        entities = ToDo.class,
        version = 8,
        exportSchema = false
)
public abstract class ToDoDatabase extends RoomDatabase {
    public abstract ToDoDao getToDoDao();
}

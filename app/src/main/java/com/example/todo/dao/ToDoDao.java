package com.example.todo.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todo.models.ToDo;

import java.util.List;

@Dao
public interface ToDoDao {
    @Insert(onConflict = REPLACE)
    void addToDo(ToDo toDo);

    @Delete
    void deleteToDo(ToDo toDo);

    @Query("SELECT * FROM todo ORDER BY id DESC")
    List<ToDo> getAllToDos();

    @Query("SELECT * FROM todo WHERE id = :id")
    ToDo getToDoById(int id);

    @Update
    void updateToDo(ToDo toDo);
}

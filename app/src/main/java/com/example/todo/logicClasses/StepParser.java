package com.example.todo.logicClasses;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.Step;
import com.example.todo.models.ToDo;

import java.util.ArrayList;
import java.util.List;

public class StepParser {
    private static ToDoDao toDoDao = null;
    int i;

    public StepParser(ToDoDao toDoDao) {
        StepParser.toDoDao = toDoDao;
    }

    public static List<Step> getAllStepsByToDoId(int toDoId) {
        ToDo toDo = toDoDao.getToDoById(toDoId);

        try {
            return getStepsArray(toDo.getSteps());
        } catch (Exception e) {
            System.out.println("getSteps was null");
            return new ArrayList<>();
        }
    }

    public static List<Step> getStepsByToDo(ToDo toDo) {
        return getAllStepsByToDoId(toDo.getId());
    }

    public static void addStepIntoTodo(ToDo toDo, Step step) {
        toDo.setSteps(toDo.getSteps() + "/" + step + " isDone=false");
        toDoDao.updateToDo(toDo);
    }

    public static void setDoneIntoStepFromTodo(ToDo todo, int stepId) {
        List<Step> stepsList = getStepsArray(todo.getSteps());
        Step step = stepsList.stream().filter(x -> x.getId() == stepId).findFirst().get();
        step.setDone(!step.isDone());

        todo.setSteps(setStepsArray(stepsList));

        toDoDao.updateToDo(todo);
    }

    public static void deleteStepInToDo(ToDo todo, int stepId) {
        List<Step> stepsList = getStepsArray(todo.getSteps());
        Step step = stepsList.stream().filter(x -> x.getId() == stepId).findFirst().get();

        stepsList.remove(step);
        todo.setSteps(setStepsArray(stepsList));

        toDoDao.updateToDo(todo);
    }

    public static String setStepsArray(List<Step> stepsList) {
        StringBuilder result = new StringBuilder();

        for (Step step : stepsList) {
            result.append("/").append(step.getContent()).append(" isDone=").append(step.isDone());
        }

        return result.toString();
    }

    private static List<Step> getStepsArray(String steps) {
        List<Step> result = new ArrayList<>();

        /*первое задание isDone=true/второе задание isDone=false*/

        String[] splitSteps = steps.split("/");

        for (int i = 0; i < splitSteps.length; i++) {
            if(splitSteps[i].equals("")) continue;

            String step = splitSteps[i];

            Step stepLocal = new Step();
            stepLocal.setId(i);

            StringBuilder stepLocalContent = new StringBuilder();
            for (String inlineStroke : step.split(" ")) {
                if (inlineStroke.equals("isDone=false") ||inlineStroke.equals("isDone=true")) {
                    String stepIsDoneValue = inlineStroke.split("=")[1];
                    stepLocal.setDone(stepIsDoneValue.equals("true"));
                    break;
                }
                else stepLocalContent.append(inlineStroke).append(" ");
            }

            stepLocal.setContent(stepLocalContent.toString());
            result.add(stepLocal);
        }

        return result;
    }
}

package com.example.todo.logicClasses;

import com.example.todo.dao.ToDoDao;
import com.example.todo.models.Step;
import com.example.todo.models.ToDo;

import java.util.ArrayList;
import java.util.List;

public class StepParser {
    public static ToDoDao toDoDao = null;

    public StepParser(ToDoDao toDoDao) {
        StepParser.toDoDao = toDoDao;
    }

    public static List<Step> getAllStepsByToDoId(int toDoId) {
        ToDo toDo = toDoDao.getToDoById(toDoId);

        try {
            return getStepsArray(toDo.getSteps());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static List<Step> getStepsByToDo(ToDo toDo) {
        return getAllStepsByToDoId(toDo.getId());
    }

    public static void addStepIntoTodo(ToDo toDo, Step step) {
        String steps = toDo.getSteps();

        if(steps == null) steps = "";

        toDo.setSteps(steps + "/" + step.getContent() + " isDone=false");
        toDoDao.updateToDo(toDo);
    }

    public static int getStepsCountInToDo(ToDo toDo) {
        return getStepsArray(toDo.getSteps()).size();
    }

    public static void setDoneIntoStepFromTodo(ToDo todo, Step step) {
        List<Step> stepsList = getStepsArray(todo.getSteps());

        for (Step step1 : stepsList) {
            System.out.println(step1);
        }


        for (Step step1 : stepsList) {
            if(step.getId() == step1.getId()) {
                step1.setDone(!step1.isDone());
            }
        }

        todo.setSteps(setStepsArray(stepsList));

        System.out.println("\n" + todo.getSteps() + "\n");

        toDoDao.updateToDo(todo);
    }

    public static String setStepsArray(List<Step> stepsList) {
        StringBuilder result = new StringBuilder();

        for (Step step : stepsList) {
            System.out.println(step.getContent() + "?" + step.isDone());
            result.append("/").append(step.getContent()).append(" isDone=").append(step.isDone());
        }

        return result.toString();
    }

    private static List<Step> getStepsArray(String steps) {
        List<Step> result = new ArrayList<>();
        //System.out.println(steps);

        /*первое задание isDone=true/второе задание isDone=false*/

        String[] splitSteps;

        try {
            splitSteps = steps.split("/");
        } catch (Exception ignored) {
            return result;
        }

        for (int i = 0; i < splitSteps.length; i++) {
            if(splitSteps[i].equals("")) continue;

            String stepString = splitSteps[i];
            //System.out.println(stepString);

            Step stepLocal = new Step();
            stepLocal.setId(i);

            StringBuilder stepLocalContent = new StringBuilder();
            for (String inlineStroke : stepString.split(" ")) {
                //System.out.println(inlineStroke);
                if (inlineStrokeIsDone(inlineStroke)) {
                    String stepIsDoneValue = inlineStroke.split("=")[1];
                    stepLocal.setDone(stepIsDoneValue.equals("true"));
                    break;
                } else {
                    stepLocalContent.append(inlineStroke);
                    if(stepLocalContent.charAt(stepLocalContent.length() - 1) != ' ')
                        stepLocalContent.append(" ");
                }
            }

            stepLocal.setContent(stepLocalContent.toString());
            result.add(stepLocal);
            //System.out.println(stepLocal);
        }

        return result;
    }

    private static boolean inlineStrokeIsDone(String inlineStroke) {
        return inlineStroke.equals("isDone=false") || inlineStroke.equals("isDone=true");
    }

    public static void removeStepInToDo(ToDo toDo, Step step) {
        List<Step> resultArray = new ArrayList<>();

        for (Step step1 : getStepsArray(toDo.getSteps())) {
            if(step1.getId() == step.getId()) continue;

            resultArray.add(step1);
        }

        for (int i = 0; i < resultArray.size(); i++) {
            Step step1 = resultArray.get(i);
            System.out.println(step1.getId() + " меняю на " + i);
            step1.setId(i);
        }

        toDo.setSteps(setStepsArray(resultArray));

        toDoDao.updateToDo(toDo);
    }
}

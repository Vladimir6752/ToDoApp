package com.example.todo.models;

public class Step {
    private int id;
    private String content;
    private boolean isDone;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isDone=" + isDone +
                "}";
    }
}

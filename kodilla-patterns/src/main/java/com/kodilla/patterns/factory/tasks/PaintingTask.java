package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task{
    String taskName;
    String color;
    String whatToPaint;
    boolean isExecuted = false;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public boolean executeTask(){
        isExecuted = true;
        return isExecuted;
    }

    @Override
    public String getTaskName(){
        return  taskName;
    }

    @Override
    public boolean isTaskExecuted(){
        if (isExecuted){
            return true;
        } else {
            return false;
        }
    }
}

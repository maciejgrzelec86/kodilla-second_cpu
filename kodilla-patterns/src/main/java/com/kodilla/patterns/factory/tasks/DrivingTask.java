package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements  Task{
    String taskName;
    String where;
    String using;
    boolean isExecuted = false;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }
    @Override
    public boolean executeTask(){
        isExecuted = true;
        return isExecuted;
    }
    @Override
    public String getTaskName(){
        return taskName;
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

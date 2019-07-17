package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    String taskName;
    String whatToBuy;
    double quantity;
    boolean isExecuted = false;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
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

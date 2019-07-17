package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String DRIVING_TASK = "DRIVING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String SHOPPING_TASK = "SHOPPING_TASK";

    public final Task executeTask (String taskClass) {
        switch (taskClass) {
            case DRIVING_TASK:
                return new DrivingTask("driving", "warsaw","car");
            case PAINTING_TASK:
                return new PaintingTask("painting", "white", "wall");
            case SHOPPING_TASK:
                return new ShoppingTask("shopping", "books", 20.0);
            default:
                return null;
        }
    }
}

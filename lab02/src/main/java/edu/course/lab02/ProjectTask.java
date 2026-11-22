package edu.course.lab02;

public class ProjectTask {

    private final String id;
    private String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, TaskStatus status, int estimatedHours) {
        
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty");
        }
        
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be null or empty");
        }
        
        if (estimatedHours < 0 ) {
            throw new IllegalArgumentException("Estimated hours cannot be negative");
        }

        this.id = id;
        this.title = title;
        this.status = status;
        this.estimatedHours = estimatedHours;

    }

    public void changeStatus(TaskStatus newStatus) {
    if (newStatus == null) {
        throw new IllegalArgumentException("Status cannot be null");
        }
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return this.status == TaskStatus.DONE;
    }

    public int addEstimatedHours(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("Added hours cannot be zero or negative");
        }
        this.estimatedHours += hours;
        return this.estimatedHours;
    }

}
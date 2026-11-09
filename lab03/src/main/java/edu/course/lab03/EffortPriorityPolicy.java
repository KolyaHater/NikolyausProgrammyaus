package edu.course.lab03;

public class EffortPriorityPolicy implements PriorityPolicy {

    @Override
    public int calculatePriority(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException("task cannot be null");
        }
        return task.getEstimatedHours();
    }
}
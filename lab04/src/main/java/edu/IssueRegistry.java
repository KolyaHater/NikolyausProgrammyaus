package edu.course.lab04;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class IssueRegistry {
    private final Map<IssueId, ProjectTask> tasks = new HashMap<>();

    public void register(ProjectTask task) {
        Objects.requireNonNull(task, "task must not be null");
        tasks.put(task.getId(), task);
    }

    public Optional<ProjectTask> findById(IssueId id) {
        Objects.requireNonNull(id, "id must not be null");
        return Optional.ofNullable(tasks.get(id));
    }

    public boolean contains(IssueId id) {
        Objects.requireNonNull(id, "id must not be null");
        return tasks.containsKey(id);
    }

    public boolean remove(IssueId id) {
        Objects.requireNonNull(id, "id must not be null");
        return tasks.remove(id) != null;
    }

    public int size() {
        return tasks.size();
    }
}
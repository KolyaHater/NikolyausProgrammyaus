package edu.course.lab04;

import java.util.Objects;

public class ProjectTask {
    private final IssueId id;
    private String title;
    private String status;

    public ProjectTask(IssueId id, String title, String status) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        this.title = title;
        this.status = (status == null || status.isBlank()) ? "OPEN" : status;
    }

    public IssueId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("status must not be blank");
        }
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProjectTask{id=" + id + ", title='" + title + "', status='" + status + "'}";
    }
}
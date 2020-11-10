package edu.baiburin.todobot.domain;

import java.time.LocalDateTime;

public class Task {
    private long taskId;
    private String authorFirstName;
    private String authorLastName;
    private String taskDescription;
    private LocalDateTime createDate;
    private boolean isArchived;
    private LocalDateTime finishDate;
    private LocalDateTime deleteDate;

    public Task() {
    }

    public Task(long taskId,
                String authorFirstName,
                String authorLastName,
                String taskDescription,
                LocalDateTime createDate,
                boolean isArchived,
                LocalDateTime finishDate,
                LocalDateTime deleteDate) {
        this.taskId = taskId;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.taskDescription = taskDescription;
        this.createDate = createDate;
        this.isArchived = isArchived;
        this.finishDate = finishDate;
        this.deleteDate = deleteDate;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }

}

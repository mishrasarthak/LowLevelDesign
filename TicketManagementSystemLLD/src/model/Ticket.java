package model;

import exceptions.IncompleteSubTasksException;
import exceptions.InvalidStatusTransitionException;

import java.util.ArrayList;
import java.util.List;

public abstract class Ticket {

    StatusTransitionRuleStrategy obj
    protected static int idCount = 1;
    protected int ticketId;
    protected String title;
    protected Status status;
    protected List<SubTask> subTasks = new ArrayList<>();

    protected String description;
    protected List<String> comments = new ArrayList<>();


    public Ticket(String title) {
        this.ticketId = idCount++;
        this.title = title;
        this.status = Status.OPEN;
    }

    public int getTicketId() {
        return ticketId;
    }
    public String getTitle() {
        return title;
    }
    public Status getStatus() {
        return status;
    }
    public List<SubTask> getSubTasks() {
        return subTasks;
    }
    public String getDescription() {
        return description;
    }
    public List<String> getComments() {
        return comments;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public abstract boolean isValidTransition(Status newStatus);

    public void updateStatus(Status newStatus) {
        if (isValidTransition(newStatus)) {
            if (newStatus == Status.DEPLOYED || newStatus == Status.COMPLETED) {
                for (SubTask subTask : subTasks) {
                    if (subTask.getStatus() != Status.COMPLETED) {
                        throw new IncompleteSubTasksException("Cannot close ticket with incomplete sub-tasks");
                    }
                }
            }
            this.status = newStatus;
        } else {
            throw new InvalidStatusTransitionException("Invalid status transition from " + status + " to " + newStatus);
        }
    }

    public void addSubTask(SubTask subTask) {
        subTasks.add(subTask);
    }

    public void removeSubTask(SubTask subTask) {
        subTasks.remove(subTask);
    }
}


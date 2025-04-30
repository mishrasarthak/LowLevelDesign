package model;

import java.util.List;

public class OnCall extends Ticket {
    public OnCall(String title) {
        super(title);
    }

    /**
     * Checks if the transition from the current status to the new status is valid.
     *
     * @param newStatus the new status to transition to
     * @return true if the transition is valid, false otherwise
     */
    @Override
    public boolean isValidTransition(Status newStatus) {
        List<Status> validFlow = List.of(Status.OPEN, Status.IN_PROGRESS, Status.RESOLVED);
        return validFlow.contains(newStatus) && status.ordinal() < newStatus.ordinal();
    }
}

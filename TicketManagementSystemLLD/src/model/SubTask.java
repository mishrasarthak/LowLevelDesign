package model;

public class SubTask extends Ticket {
    private Ticket parent;

    public SubTask(String title, Ticket parent) {
        super(title);
        this.parent = parent;
    }

    @Override
    public boolean isValidTransition(Status newStatus) {
        return parent.isValidTransition(newStatus) && status.ordinal() < newStatus.ordinal();
    }

}

import dao.IRepository;
import dao.TicketRepository;
import exceptions.IncompleteSubTasksException;
import exceptions.InvalidStatusTransitionException;
import model.*;
import util.IPrintUtil;
import util.PrintToConsole;

public class TicketManagementAppDriver {
    public static void main(String[] args) {
        IRepository<Ticket> ticketRepo = new TicketRepository();
        Sprint sprint = new Sprint();
        IPrintUtil printer = new PrintToConsole();

        Story story = new Story("Implement login feature");
        story.setDescription("This story involves implementing the login feature.");
        story.addComment("Initial draft created.");
        ticketRepo.add(story);

        Epic epic = new Epic("User authentication");
        epic.setDescription("This epic involves all stories related to user authentication project");
        ticketRepo.add(epic);

        OnCall onCall = new OnCall("Fix production bug");
        onCall.addComment("High severity bug reported in production.");
        ticketRepo.add(onCall);

        printer.print(" Tickets Created Successfully :");
        printer.print(story.getTicketId() + " : " + story.getTitle());
        printer.print(epic.getTicketId() + " : " + epic.getTitle());
        printer.print(onCall.getTicketId() + " : " + onCall.getTitle());


        story.updateStatus(Status.DEPLOYED);
        printer.print("Changing to Deployed=======");
        //Update ticket status example
        story.updateStatus(Status.IN_PROGRESS);
        printer.print("Updated Status: " + story.getTitle() + " -> " + story.getStatus());

        // Sprint Management example
        sprint.addStory(story);
        printer.print("Story added to current Sprint : " + story.getTitle());

        sprint.removeStory(story.getTicketId());
        printer.print("Story removed from current Sprint: " + story.getTitle());

        printer.print("===============");
        sprint.addStory(epic);

        // Sub-task Management example
        SubTask subTask = new SubTask("Design login UI", story);
        story.addSubTask(subTask);
        printer.print("Added SubTask: " + subTask.getTitle());

        subTask.updateStatus(Status.IN_PROGRESS);
        printer.print("Updated SubTask Status: " + subTask.getTitle() + " -> " + subTask.getStatus());

        try {
            subTask.updateStatus(Status.OPEN);
        } catch (InvalidStatusTransitionException e) {
            printer.print("Error: " + e.getMessage());
        }

        story.removeSubTask(subTask);
        printer.print("Deleted SubTask: " + subTask.getTitle());

        // Some Negative test cases
        try {
            story.updateStatus(Status.DEPLOYED);
        } catch (IncompleteSubTasksException e) {
            printer.print("Error: " + e.getMessage());
        }

        try {
            story.updateStatus(Status.TESTING);
        } catch (InvalidStatusTransitionException e) {
            printer.print("Error: " + e.getMessage());
        }
    }
}
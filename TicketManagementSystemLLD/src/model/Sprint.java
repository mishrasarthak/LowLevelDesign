package model;

import exceptions.InvalidSprintOperationException;

import java.util.HashSet;
import java.util.Set;

public class Sprint {
    private Set<Integer> storyIds = new HashSet<>();

    public void addStory(Ticket ticket) {
        if (!(ticket instanceof Story)) {
            throw new InvalidSprintOperationException("Only Story tickets can be added to a sprint.");
        }
        storyIds.add(ticket.getTicketId());
    }

    public void removeStory(int storyId) {
        storyIds.remove(storyId);
    }

    public Set<Integer> getStories() {
        return storyIds;
    }
}

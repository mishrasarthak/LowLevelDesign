package dao;

import model.Ticket;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketRepository implements IRepository<Ticket> {
    private Map<Integer, Ticket> tickets = new ConcurrentHashMap<>();

    @Override
    public void add(Ticket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
    }

    @Override
    public Ticket get(int id) {
        return tickets.get(id);
    }

    @Override
    public Collection<Ticket> getAll() {
        return tickets.values();
    }
}

package ru.netology.manager;

import ru.netology.repository.TicketRepository;
import ru.netology.ticket.Ticket;

import java.util.Arrays;

public class TicketManager {

    TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void save(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] all = repository.getAll();
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : all) {
            if (from.equalsIgnoreCase(ticket.getFrom()) && to.equalsIgnoreCase(ticket.getTo())) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}

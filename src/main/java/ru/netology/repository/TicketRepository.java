package ru.netology.repository;

import ru.netology.ticket.Ticket;

public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket product) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        tickets = tmp;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket product : tickets) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] getAll() {
        return tickets;
    }

}

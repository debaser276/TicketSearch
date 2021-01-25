package ru.netology.comparator;

import ru.netology.ticket.Ticket;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket ticket, Ticket t1) {
        return ticket.getTime() - t1.getTime();
    }
}

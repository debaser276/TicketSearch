package ru.netology.ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.comparator.TicketByTimeAscComparator;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;
import ru.netology.ticket.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketRepository repository = new TicketRepository();

    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 150, "from1", "to1", 120);
    Ticket ticket2 = new Ticket(2, 200, "from2", "to2", 130);
    Ticket ticket3 = new Ticket(3, 100, "from1", "to1", 150);
    Ticket ticket4 = new Ticket(4, 300, "from2", "to2", 100);

    @BeforeEach
    void addTickets() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
    }

    @Test
    void shouldFindAll() {
        Ticket[] expected = new Ticket[] {ticket3, ticket1};
        Ticket[] actual = manager.findAll("from1", "to1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllReturnEmpty() {
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("from3", "to3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllSortedByTime() {
        Ticket[] expected = new Ticket[] {ticket4, ticket2};
        TicketByTimeAscComparator comparator = new TicketByTimeAscComparator();
        Ticket[] actual = manager.findAll("from2", "to2", comparator);
        assertArrayEquals(expected, actual);
    }

}
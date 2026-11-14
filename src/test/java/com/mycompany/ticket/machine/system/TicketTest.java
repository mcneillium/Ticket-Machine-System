package com.mycompany.ticket.machine.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class TicketTest {

    @Test
    void standardTicketHasStandardTypeAndPrice() {
        Ticket t = new StandardTicket(1);
        assertEquals("Standard", t.getType());
        assertEquals(10.0, t.getPrice(), 1e-9);
    }

    @Test
    void studentTicketHasStudentTypeAndPrice() {
        Ticket t = new StudentTicket(1);
        assertEquals("Student", t.getType());
        assertEquals(5.0, t.getPrice(), 1e-9);
    }

    @Test
    void subclassesAreUsableThroughTheBaseType() {
        List<Ticket> tickets = List.of(new StandardTicket(2), new StudentTicket(3));
        tickets.forEach(t -> assertInstanceOf(Ticket.class, t));
        double total = tickets.stream().mapToDouble(Ticket::getPrice).sum();
        assertEquals(15.0, total, 1e-9);
    }

    @Test
    void toStringNamesTheTicketAndQuantity() {
        assertTrue(new StandardTicket(4).toString().contains("quantity=4"));
        assertTrue(new StudentTicket(2).toString().contains("type=Student"));
    }

    @Test
    void settersUpdateEncapsulatedFields() {
        Ticket t = new Ticket("Day", 12.5);
        t.setPrice(11.0);
        t.setType("Off-peak");
        assertEquals("Off-peak", t.getType());
        assertEquals(11.0, t.getPrice(), 1e-9);
    }
}

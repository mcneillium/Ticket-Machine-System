package com.mycompany.ticket.machine.system;

// The TicketPrinter class is responsible for printing the details of any Ticket object.
// It demonstrates polymorphism by accepting any subclass of Ticket and treating it the same way.
public class TicketPrinter {

    // The text printed for a ticket; kept separate so it can be tested.
    public String format(Ticket ticket) {
        return String.format("%d x %s ticket at £%.2f = £%.2f",
                ticket.getQuantity(), ticket.getType(), ticket.getPrice(), ticket.getTotalPrice());
    }

    // Accepts a Ticket object (or any subclass of Ticket) as a parameter.
    public void printTicket(Ticket ticket) {
        System.out.println(format(ticket));
    }
}

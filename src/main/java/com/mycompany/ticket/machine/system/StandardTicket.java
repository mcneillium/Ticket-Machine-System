package com.mycompany.ticket.machine.system;

// Inheritance: a Standard ticket is a Ticket with its own type and price (10.0).
// Quantity, total price and toString() come from Ticket.
public class StandardTicket extends Ticket {

    public StandardTicket(int quantity) {
        super("Standard", 10.0, quantity);
    }
}

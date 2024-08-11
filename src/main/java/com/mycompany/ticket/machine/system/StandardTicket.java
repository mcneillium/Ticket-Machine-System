package com.mycompany.ticket.machine.system;

// The StandardTicket class is a specific type of Ticket.
// It inherits the properties (fields and methods) of the Ticket class.
public class StandardTicket extends Ticket {
    // Constructor for StandardTicket that calls the superclass (Ticket) constructor.
    // It sets the type to "Standard" and the price to 10.0.
    public StandardTicket() {
        super("Standard", 10.0); // Calls the Ticket constructor with specific values for a standard ticket.
    }
}

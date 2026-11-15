package com.mycompany.ticket.machine.system;

// Inheritance: a Student ticket is a Ticket with its own type and price (5.0).
// Quantity, total price and toString() come from Ticket.
public class StudentTicket extends Ticket {

    public StudentTicket(int quantity) {
        super("Student", 5.0, quantity);
    }
}

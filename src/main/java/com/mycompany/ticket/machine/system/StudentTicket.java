package com.mycompany.ticket.machine.system;

// The StudentTicket class is another specific type of Ticket.
// It also inherits from the Ticket class, but sets different values.
public class StudentTicket extends Ticket {
    // Constructor for StudentTicket that calls the superclass (Ticket) constructor.
    // It sets the type to "Student" and the price to 5.0.
    public StudentTicket() {
        super("Student", 5.0); // Calls the Ticket constructor with specific values for a student ticket.
    }
}

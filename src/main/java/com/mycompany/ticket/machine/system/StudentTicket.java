package com.mycompany.ticket.machine.system;

public class StudentTicket extends Ticket {
    private int quantity;

    public StudentTicket(int quantity) {
        super("Student", 5.0);  // Pass the type and price to the Ticket superclass
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StudentTicket{" +
               "quantity=" + quantity +
               ", type=" + getType() +
               ", price=" + getPrice() +
               '}';
    }
}

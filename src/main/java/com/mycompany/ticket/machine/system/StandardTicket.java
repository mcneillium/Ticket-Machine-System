package com.mycompany.ticket.machine.system;

public class StandardTicket extends Ticket {
    private int quantity;

    public StandardTicket(int quantity) {
        super("Standard", 10.0);  // Pass the type and price to the Ticket superclass
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StandardTicket{" +
               "quantity=" + quantity +
               ", type=" + getType() +
               ", price=" + getPrice() +
               '}';
    }
}

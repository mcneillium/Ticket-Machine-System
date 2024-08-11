package com.mycompany.ticket.machine.system;

// The TicketPrinter class is responsible for printing the details of any Ticket object.
// It demonstrates polymorphism by accepting any subclass of Ticket and treating it the same way.
public class TicketPrinter {
    // Method to print the details of the ticket.
    // It accepts a Ticket object (or any subclass of Ticket) as a parameter.
    public void printTicket(Ticket ticket) {
        // Print the type of the ticket.
        System.out.println("Ticket Type: " + ticket.getType());
        
        // Print the price of the ticket.
        System.out.println("Price: $" + ticket.getPrice());
    }
}

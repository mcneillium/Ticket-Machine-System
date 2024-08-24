package com.mycompany.ticket.machine.system;

// The TicketMachine class serves as the entry point of the application.
// It creates instances of ticket types and prints their details.
public class TicketMachine {
    // The main method is the starting point of the Java application.
    public static void main(String[] args) {
        // Create an instance of StandardTicket with a quantity of 1.
        Ticket standardTicket = new StandardTicket(1);

        // Create an instance of StudentTicket with a quantity of 1.
        Ticket studentTicket = new StudentTicket(1);

        // Create an instance of TicketPrinter to print the ticket details.
        TicketPrinter printer = new TicketPrinter();

        // Print the details of the standard ticket.
        printer.printTicket(standardTicket);

        // Print the details of the student ticket.
        printer.printTicket(studentTicket);
    }

    // Method to issue a ticket (added for GUI compatibility).
    public void issueTicket(Ticket ticket) {
        TicketPrinter printer = new TicketPrinter();
        printer.printTicket(ticket);
    }
}

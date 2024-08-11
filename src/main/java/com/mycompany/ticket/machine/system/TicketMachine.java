package com.mycompany.ticket.machine.system;

// The TicketMachine class serves as the entry point of the application.
// It creates instances of ticket types and prints their details.
public class TicketMachine {
    // The main method is the starting point of the Java application.
    public static void main(String[] args) {
        // Create an instance of StandardTicket.
        // This object will have the type "Standard" and price 10.0.
        Ticket standardTicket = new StandardTicket();

        // Create an instance of StudentTicket.
        // This object will have the type "Student" and price 5.0.
        Ticket studentTicket = new StudentTicket();

        // Create an instance of TicketPrinter to print the ticket details.
        TicketPrinter printer = new TicketPrinter();

        // Print the details of the standard ticket.
        printer.printTicket(standardTicket);

        // Print the details of the student ticket.
        printer.printTicket(studentTicket);
    }
}

package com.mycompany.ticket.machine.system;

// The TicketMachine issues tickets and keeps a running total of its takings.
public class TicketMachine {

    // Largest number of tickets sold in one purchase.
    public static final int MAX_QUANTITY = 20;

    private final TicketPrinter printer = new TicketPrinter();
    private double takings;
    private int ticketsSold;

    // Turns what the user typed into a quantity, or explains what is wrong.
    // An empty box means one ticket, matching the box's hint.
    public static int parseQuantity(String text) {
        String trimmed = text == null ? "" : text.trim();
        if (trimmed.isEmpty()) {
            return 1;
        }
        int quantity;
        try {
            quantity = Integer.parseInt(trimmed);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Enter the quantity as a whole number, for example 2.");
        }
        if (quantity < 1 || quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("Enter a quantity from 1 to " + MAX_QUANTITY + ".");
        }
        return quantity;
    }

    // Issues a ticket (any subclass of Ticket), prints it and adds it to the takings.
    public void issueTicket(Ticket ticket) {
        printer.printTicket(ticket);
        takings += ticket.getTotalPrice();
        ticketsSold += ticket.getQuantity();
    }

    public double getTakings() {
        return takings;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    // Console demo: issues one of each ticket type.
    public static void main(String[] args) {
        TicketMachine machine = new TicketMachine();
        machine.issueTicket(new StandardTicket(1));
        machine.issueTicket(new StudentTicket(2));
        System.out.printf("Takings: £%.2f from %d tickets%n", machine.getTakings(), machine.getTicketsSold());
    }
}

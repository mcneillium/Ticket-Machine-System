package com.mycompany.ticket.machine.system;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.SequencedMap;
import java.util.function.IntFunction;

// The TicketMachine issues tickets and keeps a running total of its takings.
public class TicketMachine {

    // Largest number of tickets sold in one purchase.
    public static final int MAX_QUANTITY = 20;

    // Every ticket type the machine sells, in the order the window lists them.
    // Each entry maps a name to the constructor that builds that ticket, so
    // adding a type is one new class and one line here; nothing else changes.
    private static final SequencedMap<String, IntFunction<Ticket>> TICKET_TYPES = new LinkedHashMap<>();
    static {
        TICKET_TYPES.put("Standard", StandardTicket::new);
        TICKET_TYPES.put("Student", StudentTicket::new);
    }

    private final TicketPrinter printer = new TicketPrinter();
    private double takings;
    private int ticketsSold;

    // The names of the ticket types on sale, for the window's drop-down.
    public static List<String> ticketTypes() {
        return List.copyOf(TICKET_TYPES.sequencedKeySet());
    }

    // Builds a ticket of the named type. The caller gets back a plain Ticket
    // and never needs to know which subclass it is.
    public static Ticket createTicket(String type, int quantity) {
        IntFunction<Ticket> constructor = TICKET_TYPES.get(type);
        if (constructor == null) {
            throw new IllegalArgumentException("Unknown ticket type: " + type);
        }
        return constructor.apply(quantity);
    }

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
        } catch (NumberFormatException _) {
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

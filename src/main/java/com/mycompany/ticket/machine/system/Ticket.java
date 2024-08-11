package com.mycompany.ticket.machine.system;

// The Ticket class serves as a blueprint for different types of tickets.
// It encapsulates common properties like type and price that all tickets share.
public class Ticket {
    // Private fields to hold the ticket's type and price.
    // These fields are private to enforce encapsulation, meaning they can't be accessed directly outside this class.
    private String type;
    private double price;

    // Constructor to initialize a Ticket object with a specific type and price.
    // This constructor will be used by subclasses to set their specific values.
    public Ticket(String type, double price) {
        this.type = type;
        this.price = price;
    }

    // Getter method for the type field.
    // Allows other classes to access the type of the ticket in a controlled manner.
    public String getType() {
        return type;
    }

    // Setter method for the type field.
    // Allows other classes to change the type of the ticket in a controlled manner.
    public void setType(String type) {
        this.type = type;
    }

    // Getter method for the price field.
    // Allows other classes to access the price of the ticket in a controlled manner.
    public double getPrice() {
        return price;
    }

    // Setter method for the price field.
    // Allows other classes to change the price of the ticket in a controlled manner.
    public void setPrice(double price) {
        this.price = price;
    }
}

package com.mycompany.ticket.machine.system;

// The Ticket class serves as a blueprint for different types of tickets.
// It encapsulates common properties like type and price that all tickets share.
public class Ticket {
    // Private fields to hold the ticket's type and price.
    // These fields are private to enforce encapsulation, meaning they can't be accessed directly outside this class.
    private String type;
    private double price;
    // How many of this ticket were bought. Held here, not in each subclass,
    // so every ticket type gets it (and its total) for free.
    private int quantity = 1;

    // Constructor to initialize a Ticket object with a specific type and price.
    // This constructor will be used by subclasses to set their specific values.
    public Ticket(String type, double price) {
        this.type = type;
        this.price = price;
    }

    // Constructor used by the subclasses, which also know the quantity.
    public Ticket(String type, double price, int quantity) {
        this(type, price);
        setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    // Encapsulation at work: the object refuses a quantity that makes no sense.
    public void setQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be at least 1.");
        }
        this.quantity = quantity;
    }

    // Price of one ticket multiplied by how many were bought.
    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
               "quantity=" + quantity +
               ", type=" + type +
               ", price=" + price +
               '}';
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

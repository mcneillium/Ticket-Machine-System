package com.mycompany.ticket.machine.system;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicketMachineGUI extends Application {

    private TicketMachine ticketMachine = new TicketMachine();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ticket Machine System");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Ticket type label
        Label typeLabel = new Label("Ticket Type:");
        GridPane.setConstraints(typeLabel, 0, 0);

        // Ticket type ComboBox
        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll(TicketMachine.ticketTypes());
        typeComboBox.setValue(TicketMachine.ticketTypes().getFirst());
        GridPane.setConstraints(typeComboBox, 1, 0);

        // Quantity label
        Label quantityLabel = new Label("Quantity:");
        GridPane.setConstraints(quantityLabel, 0, 1);

        // Quantity input
        TextField quantityInput = new TextField();
        quantityInput.setPromptText("1");
        GridPane.setConstraints(quantityInput, 1, 1);

        // Button to purchase ticket
        Button purchaseButton = new Button("Purchase Ticket");
        GridPane.setConstraints(purchaseButton, 1, 2);

        // Label to display ticket info
        Label ticketInfoLabel = new Label();
        GridPane.setConstraints(ticketInfoLabel, 1, 3);

        purchaseButton.setOnAction(_ -> {
            int quantity;
            try {
                quantity = TicketMachine.parseQuantity(quantityInput.getText());
            } catch (IllegalArgumentException ex) {
                // Before, an empty or non-numeric box crashed the handler silently.
                showError(ex.getMessage());
                return;
            }

            // Polymorphism: from here on the code only knows it has a Ticket.
            Ticket ticket = TicketMachine.createTicket(typeComboBox.getValue(), quantity);

            ticketMachine.issueTicket(ticket);
            ticketInfoLabel.setText(String.format("Takings so far: £%.2f from %d tickets",
                    ticketMachine.getTakings(), ticketMachine.getTicketsSold()));
            showTicketDialog(ticket);
            quantityInput.clear();
        });

        grid.getChildren().addAll(typeLabel, typeComboBox, quantityLabel, quantityInput, purchaseButton, ticketInfoLabel);

        Scene scene = new Scene(grid, 420, 190);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showTicketDialog(Ticket ticket) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ticket Purchased");
        alert.setHeaderText(null);
        alert.setContentText(String.format(
                "You have bought %d %s ticket%s.%n%n"
                + "Price each: £%.2f%nTotal: £%.2f%n%nThank you for your purchase!",
                ticket.getQuantity(), ticket.getType(), ticket.getQuantity() == 1 ? "" : "s",
                ticket.getPrice(), ticket.getTotalPrice()));
        alert.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Check the quantity");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

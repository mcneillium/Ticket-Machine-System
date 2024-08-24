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
        typeComboBox.getItems().addAll("Standard", "Student");
        typeComboBox.setValue("Standard");
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

        purchaseButton.setOnAction(e -> {
            String type = typeComboBox.getValue();  // Get the selected value from ComboBox
            int quantity = Integer.parseInt(quantityInput.getText());

            Ticket ticket;
            if ("Student".equalsIgnoreCase(type)) {
                ticket = new StudentTicket(quantity);
            } else {
                ticket = new StandardTicket(quantity);
            }

            ticketMachine.issueTicket(ticket);
            showTicketDialog(ticket);
        });

        grid.getChildren().addAll(typeLabel, typeComboBox, quantityLabel, quantityInput, purchaseButton, ticketInfoLabel);

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showTicketDialog(Ticket ticket) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ticket Purchased");
        alert.setHeaderText(null);
        alert.setContentText("You have purchased a " + ticket.getType() + " ticket.\n\n" +
                             "Ticket Details:\n" +
                             "Type: " + ticket.getType() + "\n" +
                             "Price: £" + ticket.getPrice() + "\n" +
                             "Thank you for your purchase!");

        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

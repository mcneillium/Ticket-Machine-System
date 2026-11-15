package com.mycompany.ticket.machine.system;

import javafx.application.Application;

// Entry point for the jar. It opens the JavaFX window (it used to print a
// message and exit). A launcher class that does not extend Application is the
// usual way to start JavaFX from a plain jar.
public class TicketMachineSystem {
    public static void main(String[] args) {
        Application.launch(TicketMachineGUI.class, args);
    }
}

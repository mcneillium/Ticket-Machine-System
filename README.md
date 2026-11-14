# Ticket Machine System

[![build](https://github.com/mcneillium/Ticket-Machine-System/actions/workflows/build.yml/badge.svg)](https://github.com/mcneillium/Ticket-Machine-System/actions/workflows/build.yml)

A small Java and JavaFX ticket machine, written to show the core ideas of
object-oriented programming: inheritance, polymorphism and encapsulation.

Case study: [paulmartinmcneill.com/projects/java-ticket-machine](https://paulmartinmcneill.com/projects/java-ticket-machine/)

## What it shows

- **Encapsulation:** `Ticket` keeps its type and price private behind getters
  and setters.
- **Inheritance:** `StandardTicket` (£10) and `StudentTicket` (£5) extend
  `Ticket` and set their own type and price.
- **Polymorphism:** the GUI and `TicketPrinter` work with any `Ticket`, so a
  new ticket type needs no changes elsewhere.

## Project layout

```
src/main/java/com/mycompany/ticket/machine/system/
  Ticket.java              base class (type, price)
  StandardTicket.java      £10 ticket
  StudentTicket.java       £5 ticket
  TicketPrinter.java       prints a ticket's details
  TicketMachine.java       console demo
  TicketMachineGUI.java    JavaFX window: choose a ticket type and quantity
  TicketMachineSystem.java jar entry point
src/test/java/...          JUnit 5 tests
```

## Run it

Needs JDK 21 or later and Maven. JavaFX is downloaded by Maven.

```bash
git clone https://github.com/mcneillium/Ticket-Machine-System.git
cd Ticket-Machine-System
mvn javafx:run      # opens the GUI
mvn test            # runs the unit tests
```

The tests also run on every push (see the build badge above).

## Licence

MIT, see [LICENSE](LICENSE).

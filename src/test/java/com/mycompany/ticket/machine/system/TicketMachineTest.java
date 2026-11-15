package com.mycompany.ticket.machine.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TicketMachineTest {

    @Test
    void totalPriceUsesTheQuantity() {
        // Before, buying three standard tickets reported £10.
        assertEquals(30.0, new StandardTicket(3).getTotalPrice(), 1e-9);
        assertEquals(10.0, new StudentTicket(2).getTotalPrice(), 1e-9);
    }

    @Test
    void quantityBelowOneIsRefused() {
        assertThrows(IllegalArgumentException.class, () -> new StandardTicket(0));
    }

    @Test
    void parseQuantityAcceptsBlankAndWholeNumbers() {
        assertEquals(1, TicketMachine.parseQuantity(""));
        assertEquals(1, TicketMachine.parseQuantity("  "));
        assertEquals(4, TicketMachine.parseQuantity(" 4 "));
    }

    @Test
    void parseQuantityExplainsBadInput() {
        // Before, these threw NumberFormatException inside the button handler.
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> TicketMachine.parseQuantity("two"));
        assertEquals("Enter the quantity as a whole number, for example 2.", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> TicketMachine.parseQuantity("0"));
        assertThrows(IllegalArgumentException.class, () -> TicketMachine.parseQuantity("21"));
    }

    @Test
    void machineKeepsRunningTakings() {
        TicketMachine m = new TicketMachine();
        m.issueTicket(new StandardTicket(2));
        m.issueTicket(new StudentTicket(3));
        assertEquals(35.0, m.getTakings(), 1e-9);
        assertEquals(5, m.getTicketsSold());
    }

    @Test
    void printerShowsQuantityUnitPriceAndTotal() {
        assertEquals("3 x Student ticket at £5.00 = £15.00", new TicketPrinter().format(new StudentTicket(3)));
    }
}

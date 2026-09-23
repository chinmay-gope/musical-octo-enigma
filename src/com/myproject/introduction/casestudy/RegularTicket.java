package com.myproject.introduction.casestudy;

public class RegularTicket extends Ticket {
    public RegularTicket(int ticketId,
                         String movieName,
                         String seatNumber,
                         double basePrice) {
        super(ticketId, movieName, seatNumber, basePrice, "Regular");
    }

    @Override
    double calculatePrice() {
        return getBasePrice();
    }
}

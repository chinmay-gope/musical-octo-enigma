package com.myproject.introduction.casestudy;

public class PremiumTicket extends Ticket {
    public PremiumTicket(int ticketId,
                         String movieName,
                         String seatNumber,
                         double basePrice) {
        super(ticketId, movieName, seatNumber, basePrice, "Premium");
    }

    @Override
    double calculatePrice() {
        return getBasePrice() * 1.20;
    }
}

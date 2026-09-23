package com.myproject.introduction.casestudy;

public class VIPTicket extends Ticket {
    public VIPTicket(int ticketId,
                     String movieName,
                     String seatNumber,
                     double basePrice) {
        super(ticketId, movieName, seatNumber, basePrice, "VIP");
    }

    @Override
    double calculatePrice() {
        return getBasePrice() * 1.50;
    }
}

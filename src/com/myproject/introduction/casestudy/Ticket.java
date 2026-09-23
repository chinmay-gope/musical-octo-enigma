package com.myproject.introduction.casestudy;

public abstract class Ticket {
    private final int ticketId;
    private final String movieName;
    private final String seatNumber;
    private final double basePrice;
    private final String ticketType;

    public Ticket(int ticketId, String movieName, String seatNumber, double basePrice, String ticketType) {
        this.ticketId = ticketId;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.basePrice = basePrice;
        this.ticketType = ticketType;
    }

    abstract double calculatePrice();

    public void displayTicket() {
        System.out.println("Ticket ID   : " + ticketId);
        System.out.println("Movie       : " + movieName);
        System.out.println("Seat Number : " + seatNumber);
        System.out.println("Base Price  : " + basePrice);
        System.out.println("Ticket Type : " + ticketType);
        System.out.println("Price       : $" + calculatePrice());
        System.out.println("____________________________");
    }

    public double getBasePrice() {
        return basePrice;
    }
}

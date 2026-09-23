package com.myproject.introduction.casestudy;

public class TicketService {
    static final double BASE_PRICE = 200;

    static void main() {

        Ticket regular = new RegularTicket(101, "Avengers", "A10", BASE_PRICE);
        Ticket premium = new PremiumTicket(102, "Avengers", "B15", BASE_PRICE);
        Ticket vip = new VIPTicket(103, "Avengers", "C05", BASE_PRICE);

        System.out.println("regular price = " + regular.calculatePrice());
        System.out.println("premium price = " + premium.calculatePrice());
        System.out.println("vip price = " + vip.calculatePrice());

        System.out.println("____________Using For-each Loop____________");

        Ticket[] tickets = {regular, premium, vip};

        for (Ticket ticket : tickets) {
            ticket.displayTicket();
        }
    }
}

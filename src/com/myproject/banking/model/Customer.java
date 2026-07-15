package com.myproject.banking.model;

public record Customer(int customerId, String name, String phone, String email, String address) {

    @Override
    public String toString() {
        return """
                Customer
                -----------------------
                ID      : %d
                Name    : %s
                Phone   : %s
                Email   : %s
                Address : %s
                """.formatted(
                customerId,
                name,
                phone,
                email,
                address
        );
    }
}

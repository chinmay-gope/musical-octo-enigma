package com.myproject.banking.transaction;

import com.myproject.banking.enums.TransactionType;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Transaction {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(100000);

    private final long transactionId;
    private final TransactionType type;
    private final double amount;
    private final LocalDateTime timestamp;
    private final String description;

    public Transaction(TransactionType type,
                       double amount,
                       String description) {
        if (type == null) {
            throw new IllegalArgumentException("Transaction type cannot be null.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        this.transactionId = ID_GENERATOR.incrementAndGet();
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public long getTransactionId() {
        return transactionId;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return """
                Transaction
                -----------------------------
                ID          : %d
                Type        : %s
                Amount      : %.2f
                Time        : %s
                Description : %s
                """
                .formatted(
                        transactionId,
                        type,
                        amount,
                        timestamp,
                        description
                );
    }
}

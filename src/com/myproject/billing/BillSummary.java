package com.myproject.billing;

// A simple record to hold bill totals
public record BillSummary(
        double subtotal,
        double gst,
        double serviceCharge,
        double total) {
}
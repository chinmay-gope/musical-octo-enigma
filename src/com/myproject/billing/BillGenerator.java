package com.myproject.billing;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class BillGenerator {

    static String buildBillString(Map<MenuItem, Integer> cart, BillSummary summary) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n================== FINAL BILL ==================\n");
        sb.append(String.format("%-20s %-8s %10s%n", "Item", "Qty", "Amount"));
        sb.append("-----------------------------------------------\n");

        for (Map.Entry<MenuItem, Integer> entry : cart.entrySet()) {
            MenuItem item = entry.getKey();
            int qty = entry.getValue();
            double amount = item.price() * qty;
            sb.append(String.format("%-20s %-8d ₹%9.2f%n", item.name(), qty, amount));
        }

        sb.append("-----------------------------------------------\n");
        sb.append(String.format("%-20s %-8s ₹%9.2f%n", "Subtotal", "", summary.subtotal()));
        sb.append(String.format("%-20s %-8s ₹%9.2f%n", "GST (5%)", "", summary.gst()));
        sb.append(String.format("%-20s %-8s ₹%9.2f%n", "Service Charge (10%)", "", summary.serviceCharge()));
        sb.append("-----------------------------------------------\n");
        sb.append(String.format("%-20s %-8s ₹%9.2f%n", "TOTAL", "", summary.total()));
        sb.append("\nThank you! Visit Again.\n");

        return sb.toString();
    }


    public static void writeBillToJson(Map<MenuItem, Integer> cart, BillSummary summary) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{\n");

            sb.append("  \"items\": [\n");
            int i = 0;
            for (var entry : cart.entrySet()) {
                MenuItem item = entry.getKey();
                int qty = entry.getValue();
                double amount = item.price() * qty;

                sb.append("    {\n");
                sb.append("      \"name\": \"").append(item.name()).append("\",\n");
                sb.append("      \"price\": ").append(item.price()).append(",\n");
                sb.append("      \"quantity\": ").append(qty).append(",\n");
                sb.append("      \"amount\": ").append(amount).append("\n");
                sb.append("    }");

                if (++i < cart.size()) sb.append(",");
                sb.append("\n");
            }
            sb.append("  ],\n");

            sb.append("  \"subtotal\": ").append(summary.subtotal()).append(",\n");
            sb.append("  \"gst\": ").append(summary.gst()).append(",\n");
            sb.append("  \"serviceCharge\": ").append(summary.serviceCharge()).append(",\n");
            sb.append("  \"total\": ").append(summary.total()).append("\n");

            sb.append("}\n");

            Path path = Path.of("final_bill.json");
            Files.writeString(path, sb.toString());

            System.out.println("Bill saved to " + path.toAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error writing JSON bill: " + e.getMessage());
        }
    }

    public static void writeBillToTextFile(String bill) {
        try {
            Path path = Path.of("final_bill.txt");
            Files.writeString(path, bill);
            System.out.println("Bill saved to " + path.toAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error writing bill: " + e.getMessage());
        }
    }
}

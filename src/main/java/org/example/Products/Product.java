package org.example.Products;
import java.time.LocalDate;

public class Product {
    private String name;
    private int quantity;
    private double price;
    private boolean available;
    private LocalDate expirationDate;

    public Product(String name, int quantity, double price, boolean available, LocalDate expirationDate) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.available = available;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public boolean getAvailable() {
        return available;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
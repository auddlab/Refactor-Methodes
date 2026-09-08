package main.domain;

public class Customer {
    private int id;
    private String name;
    private int loyaltyYears;

    public Customer(int id, String name, int loyaltyYears) {
        this.id = id;
        this.name = name;
        this.loyaltyYears = loyaltyYears;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public int getLoyaltyYears() { return loyaltyYears; }
}

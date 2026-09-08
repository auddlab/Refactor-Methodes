package main.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Shipment {
    private final String reference;
    private final Customer customer;
    private final CustomerState customerState;
    private final List<Cargo> cargo = new ArrayList<>();
    private double total;
    private String status = "CREATED";

    public Shipment(String reference, Customer customer, CustomerState customerState) {
        this.reference = reference;
        this.customer = customer;
        this.customerState = customerState;
    }

    public void addCargo(Cargo item) { cargo.add(item); }
    public String getReference() { return reference; }
    public Customer getCustomer() { return customer; }
    public CustomerState getCustomerState() { return customerState; }

    public List<Cargo> getCargo() { return cargo; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

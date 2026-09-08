package main.domain;

public class CustomerState {
    private boolean active;
    private boolean suspended;
    private double accountBalance;

    public CustomerState(boolean active, boolean suspended, double accountBalance) {
        this.active = active;
        this.suspended = suspended;
        this.accountBalance = accountBalance;
    }

    public boolean isActive() { return active; }
    public boolean isSuspended() { return suspended; }
    public double getAccountBalance() { return accountBalance; }
    public void setAccountBalance(double accountBalance) { this.accountBalance = accountBalance; }
}

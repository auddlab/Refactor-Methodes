package main.service;

import main.domain.Customer;
import main.domain.CustomerState;

public class AccountService {
    public int withdraw(CustomerState customerState, double amount) {
        if (customerState.getAccountBalance() < amount) return -1;
        customerState.setAccountBalance(customerState.getAccountBalance() - amount);
        return 0;
    }

    public boolean hasMoreThanFiveYears(Customer customer) {
        return customer.getLoyaltyYears() > 5;
    }

    public int getRewardPoints(Customer customer) {
        return hasMoreThanFiveYears(customer) ? 500 : 100;
    }
}

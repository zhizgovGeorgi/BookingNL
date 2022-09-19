package bussines.impl;

import bussines.GetCustomerUC;
import domain.Customer;

import java.util.List;

public class GetCustomerUCImpl implements GetCustomerUC {
    @Override
    public Customer getCustomer(String email, String password) {
        return new Customer();
    }
}

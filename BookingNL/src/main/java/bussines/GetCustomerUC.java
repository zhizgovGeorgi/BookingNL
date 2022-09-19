package bussines;

import domain.Customer;

import java.util.List;
import java.util.Optional;

public interface GetCustomerUC {
    Customer getCustomer(String email, String password);
}

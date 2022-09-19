package bussines;

import domain.CreateCustomeRequest;
import domain.CreaterCustomerResponse;

public interface CreateCustomerUC {
    CreaterCustomerResponse createCustomer(CreateCustomeRequest request);
}

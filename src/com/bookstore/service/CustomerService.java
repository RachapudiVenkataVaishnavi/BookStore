package com.bookstore.service;


import com.bookstore.model.Customer;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    ArrayList getAllCustomers();

    Customer getCustomerByUsername(String username);
    
    Customer getCustomerByUsernameAndPassword(String username,String password);

}

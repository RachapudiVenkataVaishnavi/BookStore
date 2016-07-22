package com.bookstore.dao;


import com.bookstore.model.Customer;

import java.util.List;

public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
    
    Customer getCustomerByUsernameAndPassword(String username,String password);
}

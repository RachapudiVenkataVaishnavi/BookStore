package com.bookstore.service.impl;


import com.bookstore.dao.CustomerDao;
import com.bookstore.model.Customer;
import com.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    

    public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void addCustomer(Customer customer){
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId){
        return customerDao.getCustomerById(customerId);
    }

    public ArrayList getAllCustomers(){
        return (ArrayList) customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername (String username){
        return customerDao.getCustomerByUsername(username);
    }
    
    public Customer getCustomerByUsernameAndPassword(String username,String password)
    {
    	return customerDao.getCustomerByUsernameAndPassword(username, password);
    }

} // The End of Class;

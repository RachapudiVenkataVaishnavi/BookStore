package com.bookstore.dao.impl;

import com.bookstore.common.util.DBConnection;
import com.bookstore.dao.CustomerDao;
import com.bookstore.model.Authorities;
import com.bookstore.model.Cart;
import com.bookstore.model.Customer;
import com.bookstore.model.Users;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addCustomer(Customer customer){
    	System.out.println("in add customer");
        Session session = sessionFactory.getCurrentSession();
        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.save(customer);
        session.save(customer.getBillingAddress());
        session.save(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthorities = new Authorities();
        newAuthorities.setUsername(customer.getUsername());
        newAuthorities.setAuthority("ROLE_USER");

        session.save(newUser);
        session.save(newAuthorities);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);

        session.save(customer);
        session.save(newCart);

        session.flush();
    
    }

    public Customer getCustomerById(int customerId){
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);
    }

    public List<Customer> getAllCustomers(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;

    }

    public Customer getCustomerByUsername(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ?");
        query.setString(0, username);


        return (Customer) query.uniqueResult();
    }
    
    public Customer getCustomerByUsernameAndPassword(String username,String password){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ? and password=?");
        query.setString(0, username);
        query.setString(1, password);


        return (Customer) query.uniqueResult();
    }

} // The End of Class;
